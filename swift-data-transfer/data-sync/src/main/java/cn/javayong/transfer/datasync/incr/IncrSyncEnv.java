package cn.javayong.transfer.datasync.incr;

import com.alibaba.druid.pool.DruidDataSource;

public class IncrSyncEnv {

    private DruidDataSource targetDataSource;

    public IncrSyncEnv(DruidDataSource targetDataSource) {
        this.targetDataSource = targetDataSource;
    }

    public DruidDataSource getTargetDataSource() {
        return targetDataSource;
    }

}
