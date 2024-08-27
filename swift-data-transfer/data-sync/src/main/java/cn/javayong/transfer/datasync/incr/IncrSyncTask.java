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
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 增量同步任务
 */
public class IncrSyncTask {

    private final static Logger logger = LoggerFactory.getLogger(IncrSyncTask.class);

    private final static Integer BATCH_SIZE = 5;

    private IncrSyncEnv incrSyncEnv;

    private Thread executeThread;

    private CanalMQConnector canalMQConnector;

    private volatile byte dateMark = 0;                                 // 0: 未包含染色数据  1：开始染色阶段  2： 染色阶段结束

    public IncrSyncTask(IncrSyncEnv incrSyncEnv) {
        this.incrSyncEnv = incrSyncEnv;
    }

    public void start() {
        this.canalMQConnector = new RocketMQCanalConnector(
                incrSyncEnv.getNameServer(),
                incrSyncEnv.getTopic(),
                "dataSynIncr-" + incrSyncEnv.getTopic(),
                BATCH_SIZE,
                true
        );
        this.canalMQConnector.subscribe("*");
        this.canalMQConnector.connect();
        // 开启独立的线程执行任务
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
    }

    private void process() {
        while (true) {
            boolean success = false;
            try {
                List<FlatMessage> flatMessageList = canalMQConnector.getFlatListWithoutAck(500L, TimeUnit.MILLISECONDS);
                if (CollectionUtils.isNotEmpty(flatMessageList)) {
                    // 表做分组
                    Map<String, List<FlatMessage>> groupTables = new HashMap<String, List<FlatMessage>>();
                    // 整体步骤：
                    // 1、过滤循环消息
                    // 2、数据合并
                    // 3、update 转 insert
                    // 4、按新表合并
                    logger.info("开始收到消息");
                    for (FlatMessage flatMessage : flatMessageList) {
                        logger.info("flatMessage:" + JSON.toJSONString(flatMessage));
                        List<Map<String, String>> data = flatMessage.getData();
                        String table = flatMessage.getTable();
                        List<String> pkNames = flatMessage.getPkNames();
                        if ("tb_transaction".equalsIgnoreCase(table)) {

                        }
                    }
                    logger.info("结束收到消息");
                    success = true;
                }
            } catch (Exception e) {
                canalMQConnector.rollback();
            }
            if (success) {
                canalMQConnector.ack();
            }
        }
    }

}
