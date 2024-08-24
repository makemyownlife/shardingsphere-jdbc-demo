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

    private IncrSyncTask incrSyncTask;

    public IncrSyncService(DataSyncConfig dataSyncConfig) {
        this.dataSyncConfig = dataSyncConfig;
    }

    public void init() {
        HashMap<String, HashMap<String, Object>> incrStrategy = dataSyncConfig.getIncrStrategy();
        if (!incrStrategy.isEmpty()) {
            Map<String, Object> tableConfig = dataSyncConfig.getIncrStrategy().get("tableConfig"); // 同步表配置
            // 任务开关是否打开
            Boolean switchOpen = (Boolean) tableConfig.get("switchOpen");
            if (switchOpen) {
                // 解析数据源参数
                HashMap<String, Object> targetMap = incrStrategy.get("target");  //  目的数据库
                // 初始化数据源连接池
                DruidDataSource targetDataSource = initDataSource(targetMap);
                // 监听 rocketmq 主题名
                String topic = (String) tableConfig.get("topic");
                String tables = (String) tableConfig.get("tables");
                String nameServer = (String) tableConfig.get("nameServer");
                // 增量环境
                this.incrSyncEnv = new IncrSyncEnv(nameServer ,topic, tables, targetDataSource);
                // 新建增量任务，并启动
                this.incrSyncTask = new IncrSyncTask(incrSyncEnv);
                this.incrSyncTask.start();
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
