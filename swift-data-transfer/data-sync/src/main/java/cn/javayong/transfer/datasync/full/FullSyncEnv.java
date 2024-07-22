package cn.javayong.transfer.datasync.full;

import com.alibaba.druid.pool.DruidDataSource;

public class FullSyncEnv {

    private DruidDataSource sourceDataSource;

    private DruidDataSource targetDataSource;

    public FullSyncEnv(DruidDataSource sourceDataSource, DruidDataSource targetDataSource) {
        this.sourceDataSource = sourceDataSource;
        this.targetDataSource = targetDataSource;
    }

    public DruidDataSource getSourceDataSource() {
        return sourceDataSource;
    }

    public DruidDataSource getTargetDataSource() {
        return targetDataSource;
    }

}
