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
            Map<String, String> tableConfig = dataSyncConfig.getFullStrategy().get("tableConfig"); // 同步表配置
            Map<String, String> source = dataSyncConfig.getFullStrategy().get("source");           // 源数据源
            Map<String, String> target = dataSyncConfig.getFullStrategy().get("target");           // 目标数据源
            
        }
    }

    public void stop() {

    }

}
