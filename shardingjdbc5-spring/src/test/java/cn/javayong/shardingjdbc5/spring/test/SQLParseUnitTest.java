package cn.javayong.shardingjdbc5.spring.test;

import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.api.SQLStatementVisitorEngine;
import org.apache.shardingsphere.sql.parser.api.visitor.statement.SQLStatementVisitor;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;
import org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement;
import org.junit.Test;

import java.util.Properties;

public class SQLParseUnitTest {

    @Test
    public void testInsert() {
        boolean useCache = true;
        String sql = "insert into t_order (order_id,user_id,price) values (?,?,?)";

        // 语法树 AST
        CacheOption cacheOption = new CacheOption(128, 1024L);
        SQLParserEngine parserEngine = new SQLParserEngine("MySQL", cacheOption);
        ParseASTNode parseASTNode = parserEngine.parse(sql, useCache);

        // 通过 visit 模式
        SQLStatementVisitorEngine sqlVisitorEngine = new SQLStatementVisitorEngine("MySQL", true);
        SQLStatement sqlStatement = sqlVisitorEngine.visit(parseASTNode);
        System.out.println(sqlStatement);
    }

    @Test
    public void testSelect() {
        boolean useCache = true;
        String sql = "SELECT id, name FROM t_user WHERE status = 'ACTIVE' AND age > 18 AND a = 1";
        // 获取语法树
        CacheOption cacheOption = new CacheOption(128, 1024L);
        SQLParserEngine parserEngine = new SQLParserEngine("MySQL", cacheOption);
        ParseASTNode parseASTNode = parserEngine.parse(sql, useCache);

        SQLStatementVisitorEngine sqlVisitorEngine = new SQLStatementVisitorEngine("MySQL", true);
        SQLStatement sqlStatement = sqlVisitorEngine.visit(parseASTNode);

        System.out.println(sqlStatement);
    }

}
