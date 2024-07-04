package cn.javayong.transfer.datasync.full;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步服务
 */
public class FullSync {

    private final static Logger logger = LoggerFactory.getLogger(FullSync.class);

    private DataSyncConfig dataSyncConfig;

    public FullSync(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }

    public void start() {
        HashMap<String, HashMap<String, String>> fullStrategy = dataSyncConfig.getFullStrategy();
        if (!fullStrategy.isEmpty()) {
            Map<String, String> source = dataSyncConfig.getFullStrategy().get("source");
            Map<String, String> tableConfig = dataSyncConfig.getFullStrategy().get("tableConfig");
        }
    }

    public void stop() {

    }

}
