package cn.javayong.transfer.datasync.incr;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import cn.javayong.transfer.datasync.full.FullSyncEnv;
import cn.javayong.transfer.datasync.full.FullSyncTask;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 全量同步服务
 */
public class IncrSyncService {

    private final static Logger logger = LoggerFactory.getLogger(IncrSyncService.class);

    private DataSyncConfig dataSyncConfig;

    private IncrSyncEnv incrSyncEnv;

    public IncrSyncService(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }

    public void init() {
        HashMap<String, HashMap<String, Object>> fullStrategy = dataSyncConfig.getIncrStrategy();
        if (!fullStrategy.isEmpty()) {
            Map<String, Object> tableConfig = dataSyncConfig.getFullStrategy().get("tableConfig"); // 同步表配置
            // 任务开关是否打开
            Boolean switchOpen = (Boolean) tableConfig.get("switchOpen");
            if (switchOpen) {
                // 解析数据源参数
                HashMap<String, Object> targetMap = fullStrategy.get("target");  //  目的数据库
                // 初始化数据源连接池
                DruidDataSource targetDataSource = initDataSource(targetMap);
                // 增量环境
                this.incrSyncEnv = new IncrSyncEnv(targetDataSource);

            }
        }
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
