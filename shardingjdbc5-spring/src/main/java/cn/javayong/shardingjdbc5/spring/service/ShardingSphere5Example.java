package cn.javayong.shardingjdbc5.spring.service;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.props.ConfigurationPropertyKey;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 *  shardingsphere 原生 api 例子
 */
public class ShardingSphere5Example {

    public static void main(String[] args) throws SQLException {
        // 1. 配置真实数据源
        Map<String, DataSource> dataSourceMap = createDataSourceMap();

        // 2. 定义算法
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        Properties properties = new Properties();
        properties.put("algorithm-expression", "t_order_${order_id % 2}");
        AlgorithmConfiguration algorithmConfiguration = new AlgorithmConfiguration("INLINE", properties);
        shardingRuleConfig.getShardingAlgorithms().put("order_sharding_algorithms", algorithmConfiguration);

        // 2. 配置分片规则 指定表的分片策略（分片字段 + 分片算法）
        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order", "ds0.t_order_$->{0..1}");
        StandardShardingStrategyConfiguration shardingStrategyConfiguration = new StandardShardingStrategyConfiguration("order_id", "order_sharding_algorithms");
        orderTableRuleConfig.setTableShardingStrategy(shardingStrategyConfiguration);

        //3. 将表的分片规则加入到分片规则列表
        shardingRuleConfig.getTables().add(orderTableRuleConfig);

        //4. 配置一些属性，输出sql
        Properties props = new Properties();
        props.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), true);

        //5. 创建数据源
        List ruleList = new ArrayList<>();
        ruleList.add(shardingRuleConfig);
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, ruleList, props);
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        //6. 测试向t_order表插入8条数据，8条数据会分散到2个表
        PreparedStatement ps = connection.prepareStatement("insert into t_order (order_id,user_id,price) values (?,?,?)");
        for (long i = 1; i <= 8; i++) {
            int j = 1;
            ps.setLong(j++, i);
            ps.setLong(j++, i);
            ps.setLong(j, 100 * i);
            System.out.println(ps.executeUpdate());
        }
        connection.commit();
        ps.close();
        connection.close();
    }

    private static Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        // 配置第一个数据源
        HikariDataSource ds0 = createDruidDataSource("jdbc:mysql://localhost:3306/sj_ds0", "root", "ilxw");
        dataSourceMap.put("ds0", ds0);
        return dataSourceMap;
    }

    private static HikariDataSource createDruidDataSource(String jdbcUrl, String username, String password) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置其他DruidDataSource属性
        // dataSource.set...
        return dataSource;
    }


}
