package cn.javayong.transfer.datasync.incr;

import cn.javayong.transfer.datasync.full.FullSyncEnv;
import cn.javayong.transfer.datasync.support.Utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson2.JSON;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalMQConnector;
import com.alibaba.otter.canal.client.rocketmq.RocketMQCanalConnector;
import com.alibaba.otter.canal.protocol.FlatMessage;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 增量同步任务
 */
public class IncrSyncTask {

    private final static Logger logger = LoggerFactory.getLogger(IncrSyncTask.class);

    private final static Integer BATCH_SIZE = 2;

    private IncrSyncEnv incrSyncEnv;

    private Thread executeThread;

    private DefaultLitePullConsumer litePullConsumer;

    public IncrSyncTask(IncrSyncEnv incrSyncEnv) {
        this.incrSyncEnv = incrSyncEnv;
    }

    private volatile boolean dataMarking = false;

    public void start() {
        try {
            this.litePullConsumer = new DefaultLitePullConsumer("incrDataSyn-" + incrSyncEnv.getTopic());
            litePullConsumer.setNamesrvAddr(this.incrSyncEnv.getNameServer());
            litePullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            litePullConsumer.setPullBatchSize(BATCH_SIZE);
            // 订阅主题 TopicTest
            litePullConsumer.subscribe(this.incrSyncEnv.getTopic(), "*");
            // 开启独立的线程执行任务
            // 自动提交消费偏移量的选项设置为 false
            litePullConsumer.setAutoCommit(false);
            litePullConsumer.start();
            this.executeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        process();
                    } catch (Exception e) {
                        logger.error("process error:", e);
                    }
                }
            });
            this.executeThread.setName("incrExecuteThread-" + incrSyncEnv.getTopic());
            this.executeThread.start();
        } catch (Exception e) {
            logger.error("IncrSyncTask start error:", e);
        }
    }

    private void process() {
        this.dataMarking = fetchDataMarkingFlagFromCenterStore(this.incrSyncEnv.getTopic());
        while (true) {
            boolean success = false;
            MessageExt commitMessage = null;
            MessageQueue commitCursor = null;
            try {
                List<MessageExt> messageExtList = litePullConsumer.poll(1500);
                if (CollectionUtils.isNotEmpty(messageExtList)) {

                    commitMessage = messageExtList.get(0);
                    commitCursor = new MessageQueue(commitMessage.getTopic(), commitMessage.getBrokerName(), commitMessage.getQueueId());

                    // 整体步骤：
                    // 1、过滤循环消息
                    // 2、数据合并
                    // 3、update 转 insert
                    // 4、按新表合并
                    logger.info("开始收到消息");
                    Map<String, List<FlatMessage>> tableGroup = new HashMap<>();
                    for (MessageExt messageExt : messageExtList) {
                        FlatMessage flatMessage = JSON.parseObject(messageExt.getBody(), FlatMessage.class);
                        logger.info("flatMessage:" + JSON.toJSONString(flatMessage));
                        List<Map<String, String>> data = flatMessage.getData();
                        String table = flatMessage.getTable();
                        List<String> pkNames = flatMessage.getPkNames();

                        if (!table.equals("tb_transaction")) {
                            if (!dataMarking) {
                                List<FlatMessage> tableItems = tableGroup.get(table);
                                if (tableItems == null) {
                                    tableItems = new ArrayList<>();
                                }
                                tableItems.add(flatMessage);
                                tableGroup.put(table, tableItems);
                            }
                        } else {
                            // 当遇到 table = order 时，且 status = 1 则表明是 染色数据 开始部分
                            Map<String, String> item = data.get(0);
                            if (item.get("status").equals("1") && flatMessage.getType().equals("UPDATE")) {
                                dataMarking = true;
                            }
                            // 当遇到 table = order 时，且 status = 0 则表明是 染色数据 结束
                            if (item.get("status").equals("0") && flatMessage.getType().equals("UPDATE")) {
                                dataMarking = false;
                            }
                        }
                    }

                    logger.info("结束收到消息");

                    if (MapUtils.isNotEmpty(tableGroup)) {
                        Connection targetConnection = incrSyncEnv.getTargetDataSource().getConnection();
                        targetConnection.setAutoCommit(false);
                        // STEP 1: 首先将事务染色表 状态修改为 1
                        dataMarkTransaction(targetConnection, 1);
                        // STEP 2:  处理真实的去掉数据染色部分数据
                        for (Map.Entry<String, List<FlatMessage>> entry : tableGroup.entrySet()) {
                            List<FlatMessage> messages = entry.getValue();
                            for (FlatMessage flatMessage : messages) {
                                writeRowDataToTargetDataSource(targetConnection, flatMessage);
                            }
                        }
                        // STEP 3:  最后将事务染色表 状态修改为 0
                        dataMarkTransaction(targetConnection, 0);
                        targetConnection.commit();
                    }

                    success = true;

                    // 处理染色标识
                    commitDataDataMarkingFlag(incrSyncEnv.getTopic(), dataMarking);

                    if (success) {
                        litePullConsumer.commitSync();
                    }

                }
            } catch (Exception e) {
                logger.error("process error:", e);
                success = false;
            }
            if (!success) {
                if (commitCursor != null && commitMessage != null) {
                    try {
                        litePullConsumer.seek(commitCursor, commitMessage.getQueueOffset());
                        Thread.sleep(500L);
                    } catch (Exception e) {
                        logger.error("seek error:", e);
                    }
                }
            }
        }
    }

    private void writeRowDataToTargetDataSource(Connection connection, FlatMessage flatMessage) throws Exception {
        List<Map<String, String>> data = flatMessage.getData();
        Map<String, Integer> sqlType = flatMessage.getSqlType();
        if ("UPDATE".equals(flatMessage.getType())) {
            for (Map<String, String> item : data) {
                Map<String, String> rowData = new LinkedHashMap<>();
                rowData.putAll(item);
                // 组装 UPDATE SQL
                StringBuilder updateSql = new StringBuilder();
                updateSql.append("UPDATE ").append(flatMessage.getTable()).append(" SET ");

                List<String> params = new ArrayList<>();
                rowData.forEach((key, value) -> {
                    if (!"id".equals(key)) {
                        params.add(key);
                        updateSql.append(key + "= ?,");
                    }
                });
                int len = updateSql.length();
                updateSql.delete(len - 1, len).append(" WHERE id = ?");
                System.out.println(updateSql);
                params.add("id");

                // 设置预编译
                PreparedStatement targetPreparedStatement = connection.prepareStatement(updateSql.toString());
                // step 2.2  设置 targetPreparedStatement 的每个字段值
                for (int i = 0; i < params.size(); i++) {
                    String columnName = params.get(i);
                    String value = rowData.get(columnName);
                    Integer type = sqlType.get(columnName);
                    Utils.setPStmt(type, targetPreparedStatement, value, i + 1);
                }
                targetPreparedStatement.executeUpdate();
                targetPreparedStatement.close();
            }
        }
    }

    private void dataMarkTransaction(Connection connection, Integer status) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "update tb_transaction set status = " + status + " where tablename = 'order'";
        statement.executeUpdate(sql);
        statement.close();
    }

    private boolean fetchDataMarkingFlagFromCenterStore(String topic) {
        // TODO 从 zookeeper 或者 MySQL 查询整个存储当前增量同步任务是否处于染色中
        return false;
    }

    private void commitDataDataMarkingFlag(String topic, boolean dataMarking) {
        // TODO 写入到 zookeeper 或者 MySQL
    }

}
