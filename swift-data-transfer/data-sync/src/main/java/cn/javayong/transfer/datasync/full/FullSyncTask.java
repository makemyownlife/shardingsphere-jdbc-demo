package cn.javayong.transfer.datasync.full;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
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
        try {
            // 读取当前最小 id
            Connection sourceConnection = sourceDataSource.getConnection();
            DatabaseMetaData SourceMetaData = sourceConnection.getMetaData();


            String tableName = "t_ent_order";
            ResultSet columns = SourceMetaData.getColumns(
                    null,
                    null,
                    tableName,
                    null
            );

            // 4. 遍历结果集并输出列信息
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int dataType = columns.getInt("DATA_TYPE");

                // 将 SQL 类型代码转换为类型名称
                String typeName = getTypeName(dataType);

                System.out.println("Column Name: " + columnName + ", Type: " + columnType + ", SQL Type: " + typeName);
            }

        } catch (Exception e) {
        }
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
        //

        if (sourceDataSource != null) {
            sourceDataSource.close();
        }
        if (targetDataSource != null) {
            targetDataSource.close();
        }
    }

    private static String getTypeName(int dataType) {
        switch (dataType) {
            case Types.VARCHAR:
                return "VARCHAR";
            case Types.CHAR:
                return "CHAR";
            case Types.LONGVARCHAR:
                return "LONGVARCHAR";
            case Types.NUMERIC:
                return "NUMERIC";
            case Types.DECIMAL:
                return "DECIMAL";
            case Types.BIT:
                return "BIT";
            case Types.TINYINT:
                return "TINYINT";
            case Types.SMALLINT:
                return "SMALLINT";
            case Types.INTEGER:
                return "INTEGER";
            case Types.BIGINT:
                return "BIGINT";
            case Types.REAL:
                return "REAL";
            case Types.FLOAT:
                return "FLOAT";
            case Types.DOUBLE:
                return "DOUBLE";
            case Types.BINARY:
                return "BINARY";
            case Types.VARBINARY:
                return "VARBINARY";
            case Types.LONGVARBINARY:
                return "LONGVARBINARY";
            case Types.DATE:
                return "DATE";
            case Types.TIME:
                return "TIME";
            case Types.TIMESTAMP:
                return "TIMESTAMP";
            case Types.CLOB:
                return "CLOB";
            case Types.BLOB:
                return "BLOB";
            case Types.ARRAY:
                return "ARRAY";
            case Types.STRUCT:
                return "STRUCT";
            case Types.REF:
                return "REF";
            case Types.DATALINK:
                return "DATALINK";
            case Types.BOOLEAN:
                return "BOOLEAN";
            case Types.ROWID:
                return "ROWID";
            case Types.NCHAR:
                return "NCHAR";
            case Types.NVARCHAR:
                return "NVARCHAR";
            case Types.LONGNVARCHAR:
                return "LONGNVARCHAR";
            case Types.NCLOB:
                return "NCLOB";
            case Types.SQLXML:
                return "SQLXML";
            case Types.REF_CURSOR:
                return "REF_CURSOR";
            case Types.TIME_WITH_TIMEZONE:
                return "TIME_WITH_TIMEZONE";
            case Types.TIMESTAMP_WITH_TIMEZONE:
                return "TIMESTAMP_WITH_TIMEZONE";
            default:
                return "UNKNOWN";
        }

    }

}
