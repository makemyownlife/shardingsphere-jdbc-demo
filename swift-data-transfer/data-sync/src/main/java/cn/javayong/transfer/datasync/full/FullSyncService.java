package cn.javayong.transfer.datasync.full;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步服务
 */
public class FullSyncService {

    private final static Logger logger = LoggerFactory.getLogger(FullSyncService.class);

    private DataSyncConfig dataSyncConfig;

    private FullSyncEnv fullSyncEnv;

    public FullSyncService(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }

    public void init() {
        HashMap<String, HashMap<String, Object>> fullStrategy = dataSyncConfig.getFullStrategy();
        if (!fullStrategy.isEmpty()) {
            Map<String, Object> tableConfig = dataSyncConfig.getFullStrategy().get("tableConfig"); // 同步表配置
            // 任务开关是否打开
            Boolean switchOpen = (Boolean) tableConfig.get("switchOpen");
            if (switchOpen) {
                // 解析数据源参数
                HashMap<String, Object> sourceMap = fullStrategy.get("source");  //  源数据库
                HashMap<String, Object> targetMap = fullStrategy.get("target");  //  目的数据库

                // 初始化数据源连接池
                DruidDataSource sourceDataSource = initDataSource(sourceMap);
                DruidDataSource targetDataSource = initDataSource(targetMap);
                // 全量环境
                this.fullSyncEnv = new FullSyncEnv(sourceDataSource, targetDataSource);

                // 循环遍历每个表 ，进行同步调度
                String[] tableNames = StringUtils.split((String) tableConfig.get("tables"), ",");

                for (String tableName : tableNames) {
                    // 启动调度任务执行 全量同步逻辑
                    FullSyncTask fullSyncTask = new FullSyncTask(fullSyncEnv, tableName);
                    fullSyncTask.start();
                }
            }
        }
    }

    public void destroy() {
    }

    //==============================================================================================  set method ====================================================================
    private DruidDataSource initDataSource(HashMap<String, Object> map) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(String.valueOf(map.get("url")));
        dataSource.setUsername(String.valueOf(map.get("username")));
        dataSource.setPassword(String.valueOf(map.get("password")));
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(30);
        try {
            dataSource.init();
        } catch (Exception e) {
            logger.error("init error:", e);
        }
        return dataSource;
    }

}
