package cn.javayong.shardingjdbc5.spring.javaapi;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.infra.config.props.ConfigurationPropertyKey;
import org.apache.shardingsphere.infra.config.rule.RuleConfiguration;
import org.apache.shardingsphere.mode.repository.standalone.StandalonePersistRepositoryConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

/**
 * 原生 shardingsphere jdbc api 使用例子
 */
public class Shardingsphere5Exapmle {

    public static void main(String[] args) throws Exception {
        // 0. 模式配置
        ModeConfiguration modeConfig = createModeConfiguration();

        // 1. 配置真实数据源
        Map<String, DataSource> dataSourceMap = createDataSourceMap();

        // 2. 配置每个逻辑表的分片规则
        // 表名： t_order 的配置规则
        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order", "ds0.t_order_$->{0..1}");
        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "t_order_inlne"));

        // 3. 分片配置类
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        // 配置算法规则
        Properties algorithmrProps = new Properties();
        algorithmrProps.put("algorithm-expression", "t_order_$->{order_id % 2}");
        // 添加 算法： t_order_inlne
        shardingRuleConfiguration.getShardingAlgorithms().put("t_order_inlne", new AlgorithmConfiguration("INLINE", algorithmrProps));
        // 将逻辑表 t_order 分片规则到分片规则里
        shardingRuleConfiguration.getTables().add(orderTableRuleConfig);

        // C. 分片规则 转换为集合对象
        Collection<RuleConfiguration> ruleConfigs = new ArrayList<>();
        //将表的分片规则加入到分片规则列表
        ruleConfigs.add(shardingRuleConfiguration);

        // 4. 配置一些属性
        Properties props = new Properties();
        //输出sql
        props.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), true);

        // 5 创建数据源
        String dataSourceName = "orderBase";
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(
                dataSourceName,  // 数据源名称
                modeConfig,      // 模式
                dataSourceMap,   // 数据源 Map
                ruleConfigs,     // 规则配置
                props);          // 属性

        // 6. 测试向t_order表插入8条数据，8条数据会分散到2个表
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement ps = connection.prepareStatement("insert into t_order (order_id,user_id,price) values (?,?,?)");
        for (long i = 1; i <= 8; i++) {
            int j = 1;
            ps.setLong(j++, i);
            ps.setLong(j++, i);
            ps.setLong(j, 100 * i);
            System.out.println(ps.executeUpdate());
        }
        connection.commit();

        // 测试查询
        ps = connection.prepareStatement("select * from t_order t where  t.order_id in (1,2,3,4,5,19,18,17,14)");
        ps.executeQuery();

        ps.close();
        connection.close();
    }

    private static Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        // 配置第一个数据源
        HikariDataSource ds0 = createDataSource("jdbc:mysql://localhost:3306/sj_ds0", "root", "ilxw");
        dataSourceMap.put("ds0", ds0);
        return dataSourceMap;
    }

    private static HikariDataSource createDataSource(String jdbcUrl, String username, String password) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置其他DruidDataSource属性
        // dataSource.set...
        return dataSource;
    }

    private static ModeConfiguration createModeConfiguration() {
        return new ModeConfiguration("Standalone", new StandalonePersistRepositoryConfiguration("JDBC", new Properties()));
    }

//    private static ModeConfiguration createModeConfigurationCluster() {
//        return new ModeConfiguration("Cluster", new ClusterPersistRepositoryConfiguration("ZooKeeper", "governance-sharding-db", "localhost:2181", new Properties()));
//    }

}
