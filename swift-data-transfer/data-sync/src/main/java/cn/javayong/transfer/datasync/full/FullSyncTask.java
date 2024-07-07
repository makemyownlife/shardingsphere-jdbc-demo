package cn.javayong.transfer.datasync.full;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步任务
 */
public class FullSyncTask {

    private final static Logger logger = LoggerFactory.getLogger(FullSyncTask.class);

    private HashMap<String, HashMap<String, Object>> fullStrategy;

    public FullSyncTask(HashMap<String, HashMap<String, Object>> fullStrategy) {
        this.fullStrategy = fullStrategy;
    }

    public void start() {
        Map<String, Object> tableConfig = fullStrategy.get("tableConfig"); // 同步表配置

        // 解析参数，开启独立的线程执行任务


    }

    public void stop() {

    }

}
