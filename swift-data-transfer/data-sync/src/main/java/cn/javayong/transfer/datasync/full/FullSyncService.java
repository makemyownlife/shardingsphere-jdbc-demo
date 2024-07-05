package cn.javayong.transfer.datasync.full;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步服务
 */
public class FullSyncService {

    private final static Logger logger = LoggerFactory.getLogger(FullSyncService.class);

    private DataSyncConfig dataSyncConfig;

    public FullSyncService(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }

    public void start() {
        HashMap<String, HashMap<String, Object>> fullStrategy = dataSyncConfig.getFullStrategy();
        if (!fullStrategy.isEmpty()) {
            Map<String, Object> tableConfig = dataSyncConfig.getFullStrategy().get("tableConfig"); // 同步表配置
            // 任务开关是否打开
            Boolean switchOpen = (Boolean) tableConfig.get("switchOpen");
            if (switchOpen) {
                // 启动调度任务执行 全量同步逻辑

            }
        }
    }

    public void stop() {

    }

}
