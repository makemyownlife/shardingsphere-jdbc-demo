package cn.javayong.transfer.datasync.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.image.ImageWatched;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedHashMap;

public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static LinkedHashMap<String, Integer> getColumnTypes(DataSource dataSource, String tableName) {

        LinkedHashMap<String, Integer> columnTypes = new LinkedHashMap<>(16);

        Connection sourceConnection = null;
        ResultSet columnsResultSet = null;
        try {
            sourceConnection = dataSource.getConnection();
            DatabaseMetaData SourceMetaData = sourceConnection.getMetaData();

            columnsResultSet = SourceMetaData.getColumns(
                    null,
                    null,
                    tableName,
                    null
            );
            // 4. 遍历结果集并输出列信息
            while (columnsResultSet.next()) {
                String columnName = columnsResultSet.getString("COLUMN_NAME");
                String columnType = columnsResultSet.getString("TYPE_NAME");
                int dataType = columnsResultSet.getInt("DATA_TYPE");

                // 将 SQL 类型代码转换为类型名称
                String typeName = getTypeName(dataType);
                log.warn("表名：" + tableName + " Column Name: " + columnName + ", Type: " + columnType + ", SQL Type: " + typeName);
                columnTypes.put(columnName, dataType);
            }
        } catch (Exception e) {
            log.error("表名：" + tableName + " 获取列类型异常:", e);
        } finally {
            if (columnsResultSet != null) {
                try {
                    columnsResultSet.close();
                } catch (Exception e) {
                    log.error("columnsResultSet close error:", e);
                }
            }
            if (sourceConnection != null) {
                try {
                    sourceConnection.close();
                } catch (Exception e) {
                    log.error("sourceConnection close error:", e);
                }
            }
        }
        return columnTypes;
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
