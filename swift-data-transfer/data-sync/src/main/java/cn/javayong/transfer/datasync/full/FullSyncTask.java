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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全量同步任务
 */
public class FullSyncTask {

    private final static Logger logger = LoggerFactory.getLogger(FullSyncTask.class);

    private FullSyncEnv fullSyncEnv;

    private String tableName;

    private DruidDataSource sourceDataSource;

    private DruidDataSource targetDataSource;

    private Thread executeThread;

    public FullSyncTask(FullSyncEnv fullSyncEnv, String tableName) {
        this.fullSyncEnv = fullSyncEnv;
        this.sourceDataSource = fullSyncEnv.getSourceDataSource();
        this.targetDataSource = fullSyncEnv.getTargetDataSource();
        this.tableName = tableName;
    }

    public void start() {
        // 开启独立的线程执行任务
        this.executeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process(tableName);
                } catch (Exception e) {
                    logger.error("process error:", e);
                }
            }
        });
        this.executeThread.setName("fullExecuteThread-" + tableName);
        this.executeThread.start();
    }

    private void process(String tableName) {
        long start = System.currentTimeMillis();
        logger.info("开始全量同步表：" + tableName);
        int count = 0;
        try {
            LinkedHashMap<String, Integer> columnTypes = Utils.getColumnTypes(sourceDataSource, tableName);
            // 构造游标 SQL
            String querySQL = "select * from " + tableName + " order by id";
            Connection sourceConnection = sourceDataSource.getConnection();
            // 执行查询查询语句
            PreparedStatement preparedStatement = sourceConnection.prepareStatement(querySQL, ResultSet.TYPE_FORWARD_ONLY, // 设置游标类型，这里是只进游标
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

                columnTypes.forEach((targetColumnName, srcColumnName) -> insertSql.append("`").append(targetColumnName).append("`").append(","));

                int len = insertSql.length();
                insertSql.delete(len - 1, len).append(") VALUES (");
                int mapLen = columnTypes.size();
                for (int i = 0; i < mapLen; i++) {
                    insertSql.append("?,");
                }
                len = insertSql.length();
                insertSql.delete(len - 1, len).append(")");

                // 写入另一个数据源
                writeRowDataToTargetDataSource(rowData, columnTypes, insertSql.toString());
                count++;
            }
            resultSet.close();
            preparedStatement.close();
            sourceConnection.close();
        } catch (Exception e) {
            logger.error(" process tableName:" + tableName + " occur error:", e);
        }
        logger.info("结束全量同步表：" + tableName + " 耗时:" + (System.currentTimeMillis() - start) + " 处理记录数:" + count);
    }

    private void writeRowDataToTargetDataSource(Map<String, Object> rowData, LinkedHashMap<String, Integer> columnTypes, String insertSql) throws Exception {
        try {
            // step 2.1  然后将数据插入到目标数据库 , 获取目标数据源连接
            Connection targetConnection = targetDataSource.getConnection();
            PreparedStatement targetPreparedStatement = targetConnection.prepareStatement(insertSql);
            // step 2.2  设置 targetPreparedStatement 的每个字段值
            List<Map.Entry<String, Object>> rowDataForList = rowData.entrySet().stream().collect(Collectors.toList());
            for (int i = 0; i < rowDataForList.size(); i++) {
                Map.Entry<String, Object> columnObject = rowDataForList.get(i);
                int type = columnTypes.get(columnObject.getKey());
                Object value = columnObject.getValue();
                Utils.setPStmt(type, targetPreparedStatement, value, i + 1);
            }
            // step 2.3 执行 PreparedStatement
            targetPreparedStatement.executeUpdate();
            targetPreparedStatement.close();
            targetConnection.close();
        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry") || e.getMessage().startsWith("ORA-00001:")) {
                // 目标数据源 包含该行
            } else {
                Thread.sleep(1000L);
                throw e;
            }
        }
    }

}
