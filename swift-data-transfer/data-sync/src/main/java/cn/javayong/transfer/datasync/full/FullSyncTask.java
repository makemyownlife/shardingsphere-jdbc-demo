package cn.javayong.transfer.datasync.full;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步任务
 */
public class FullSyncTask {

    private final static Logger logger = LoggerFactory.getLogger(FullSyncTask.class);

    private HashMap<String, HashMap<String, Object>> fullStrategy;

    private DruidDataSource sourceDataSource;

    private DruidDataSource targetDataSource;

    private Thread executeThread;

    public FullSyncTask(HashMap<String, HashMap<String, Object>> fullStrategy) {
        this.fullStrategy = fullStrategy;
    }

    public void start() {
        Map<String, Object> tableConfig = fullStrategy.get("tableConfig"); // 同步表配置
        // 解析数据源参数
        HashMap<String, Object> sourceMap = fullStrategy.get("source");  //  源数据库
        HashMap<String, Object> targetMap = fullStrategy.get("target");  //  目的数据库

        // 初始化数据源连接池
        this.sourceDataSource = initDataSource(sourceMap);
        this.targetDataSource = initDataSource(targetMap);

        // 开启独立的线程执行任务
        this.executeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        this.executeThread.setName("fullExecuteThread");
        this.executeThread.start();
    }

    private void process() {
        while (true) {
            try {
                // 读取当前最小 id
                Connection sourceConnection = sourceDataSource.getConnection();
                DatabaseMetaData SourceMetaData = sourceConnection.getMetaData();

                String tableName = "your_table";
                ResultSet columnsResultRs = SourceMetaData.getColumns(null, null, tableName, null);
                

            } catch (Exception e) {
            }
        }
    }

    private DruidDataSource initDataSource(HashMap<String, Object> map) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(String.valueOf(map.get("url")));
        dataSource.setUsername(String.valueOf(map.get("username")));
        dataSource.setUsername(String.valueOf(map.get("password")));
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(30);
        try {
            dataSource.init();
        } catch (Exception e) {
            logger.error("init error:", e);
        }
        return dataSource;
    }

    public void stop() {
        //

        if (sourceDataSource != null) {
            sourceDataSource.close();
        }
        if (targetDataSource != null) {
            targetDataSource.close();
        }
    }

}
