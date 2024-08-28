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
        while (true) {
            boolean success = false;
            boolean dataComplete = true;
            MessageExt commitMessage = null;
            MessageQueue commitCursor = null;
            try {
                List<MessageExt> messageExtList = litePullConsumer.poll(1500);
                if (CollectionUtils.isNotEmpty(messageExtList)) {
                    Map<String, List<FlatMessage>> tableGroup = new HashMap<>();

                    commitMessage = messageExtList.get(0);
                    commitCursor = new MessageQueue(commitMessage.getTopic(), commitMessage.getBrokerName(), commitMessage.getQueueId());

                    // 整体步骤：
                    // 1、过滤循环消息
                    // 2、数据合并
                    // 3、update 转 insert
                    // 4、按新表合并
                    logger.info("开始收到消息");
                    int dataMark = 0;
                    for (MessageExt messageExt : messageExtList) {
                        FlatMessage flatMessage = JSON.parseObject(messageExt.getBody(), FlatMessage.class);
                        logger.info("flatMessage:" + JSON.toJSONString(flatMessage));
                        List<Map<String, String>> data = flatMessage.getData();
                        String table = flatMessage.getTable();
                        List<String> pkNames = flatMessage.getPkNames();

                        if (!table.equals("tb_transaction")) {
                            if (dataMark == 0) {
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
                                dataMark++;
                            }
                            if (item.get("status").equals("0") && flatMessage.getType().equals("UPDATE")) {
                                dataMark--;
                            }
                        }
                    }

                    if (dataMark == 0) {
                        dataComplete = true;
                    } else {
                        dataComplete = false;
                    }

                    logger.info("结束收到消息");

                    if (MapUtils.isNotEmpty(tableGroup) && dataComplete) {
                        Connection targetConnection = incrSyncEnv.getTargetDataSource().getConnection();
                        targetConnection.setAutoCommit(false);
                        // STEP 1: 首先将事务染色表 状态修改为 1
                        dataMarkTransaction(targetConnection, 1);
                        //STEP 2:  处理真实的去掉数据染色部分数据
                        for (Map.Entry<String, List<FlatMessage>> entry : tableGroup.entrySet()) {
                            String tableName = entry.getKey();
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
                    if (success && dataComplete) {
                        litePullConsumer.commitSync();
                    }
                }
            } catch (Exception e) {
                logger.error("process error:", e);
                success = false;
            }
            if (!success || !dataComplete) {
                if (!dataComplete) {
                    litePullConsumer.setPullBatchSize(50);
                    logger.warn("数据包不完整，需要重新获取！");
                }
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
        String type = flatMessage.getType();
        if ("UPDATE".equals(type)) {
            for (Map<String, String> item : data) {
                StringBuilder updateSql = new StringBuilder();
                updateSql.append("UPDATE ").append(flatMessage.getTable()).append(" SET ");
                item.forEach((key, value) -> {
                    updateSql.append(key + "= ?,");
                });
                System.out.println(updateSql);
                int len = updateSql.length();
                updateSql.delete(len - 2, len).append(" WHERE ");
            }
        }
    }

    private void dataMarkTransaction(Connection connection, Integer status) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "update tb_transaction set status = " + status + " where tablename = 'order'";
        statement.executeUpdate(sql);
        statement.close();
    }

}
