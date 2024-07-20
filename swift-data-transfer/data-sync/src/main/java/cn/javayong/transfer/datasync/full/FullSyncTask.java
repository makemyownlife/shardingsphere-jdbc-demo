package cn.javayong.transfer.datasync.full;

import cn.javayong.transfer.datasync.support.Utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
                try {
                    String[] tableNames = StringUtils.split(
                            (String) tableConfig.get("tables"),
                            ",");
                    for (String tableName : tableNames) {
                        process(tableName);
                    }
                } catch (Exception e) {
                    logger.error("process error:", e);
                }
            }
        });
        this.executeThread.setName("fullExecuteThread");
        this.executeThread.start();
    }

    private void process(String tableName) {
        long start = System.currentTimeMillis();
        logger.info("开始全量同步表：" + tableName);
        try {
            LinkedHashMap<String, Integer> columnTypes = Utils.getColumnTypes(sourceDataSource, tableName);
            // 构造游标 SQL
            String querySQL = "select * from " + tableName + " order by id";
            Connection sourceConnection = sourceDataSource.getConnection();
            // 执行查询查询语句
            PreparedStatement preparedStatement = sourceConnection.prepareStatement(
                    querySQL,
                    ResultSet.TYPE_FORWARD_ONLY, // 设置游标类型，这里是只进游标
                    ResultSet.CONCUR_READ_ONLY); // 设置并发模式，这里是只读
            preparedStatement.setFetchSize(10);  // 游标 每次获取 10 条数据
            // 获取结果
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 将数据转换成 RowData 对象 ，然后将数据存储到目标数据源
                Map<String, Object> rowData = new LinkedHashMap<>(columnTypes.size());
                // 遍历每一个列 ，构造 RowData 对象
                for (String columnName : columnTypes.keySet()) {
                    rowData.put(columnName, resultSet.getObject(columnName));
                }
                // 首先组装 insertSQL
                StringBuilder insertSql = new StringBuilder();
                insertSql.append("INSERT INTO ").append(tableName).append(" (");

                columnTypes.forEach((targetColumnName, srcColumnName) -> insertSql.append("`")
                        .append(targetColumnName)
                        .append("`")
                        .append(","));

                int len = insertSql.length();
                insertSql.delete(len - 1, len).append(") VALUES (");
                int mapLen = columnTypes.size();
                for (int i = 0; i < mapLen; i++) {
                    insertSql.append("?,");
                }
                len = insertSql.length();
                insertSql.delete(len - 1, len).append(")");

            }
            resultSet.close();
            preparedStatement.close();
            sourceConnection.close();
        } catch (Exception e) {
            logger.error(" process tableName:" + tableName + " occur error:", e);
        }
        logger.info("结束全量同步表：" + tableName + " 耗时:" + (System.currentTimeMillis() - start));
    }

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

    public void stop() {
        if (sourceDataSource != null) {
            sourceDataSource.close();
        }
        if (targetDataSource != null) {
            targetDataSource.close();
        }
    }

}
