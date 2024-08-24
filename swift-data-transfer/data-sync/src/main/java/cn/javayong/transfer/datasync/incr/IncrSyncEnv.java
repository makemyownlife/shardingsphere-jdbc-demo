package cn.javayong.transfer.datasync.incr;

import com.alibaba.druid.pool.DruidDataSource;

public class IncrSyncEnv {

    private DruidDataSource targetDataSource;

    private String nameServer;

    private String topic;

    private String tables;

    public IncrSyncEnv(String nameServer, String topic, String tables, DruidDataSource targetDataSource) {
        this.nameServer = nameServer;
        this.topic = topic;
        this.tables = tables;
        this.targetDataSource = targetDataSource;
    }

    public DruidDataSource getTargetDataSource() {
        return targetDataSource;
    }

    public String getTopic() {
        return topic;
    }

    public String getTables() {
        return tables;
    }

    public String getNameServer() {
        return nameServer;
    }

}
