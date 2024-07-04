package cn.javayong.transfer.datasync.full;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 全量同步服务
 */
public class FullSync {

    private final static Logger logger = LoggerFactory.getLogger(FullSync.class);

    private DataSyncConfig dataSyncConfig;

    public FullSync(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }



}
