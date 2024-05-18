package cn.javayong.shardingjdbc4.spring.javaapi;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.underlying.common.config.properties.ConfigurationPropertyKey;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ShardingSphere4Example {

    public static void main(String[] args) throws SQLException {

        // 1. 配置真实数据源
        Map<String, DataSource> dataSourceMap = createDataSourceMap();

        // 2. 配置分片规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_order", "ds0.t_order_$->{0..1}");
        // 指定表的分片策略（分片字段+分片算法）
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_$->{order_id % 2}"));

        // 3. 分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        //将表的分片规则加入到分片规则列表
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        // 4. 配置一些属性
        Properties props = new Properties();
        //输出sql
        props.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), true);

        // 5 创建数据源
        DataSource dataSource = ShardingDataSourceFactory.
                createDataSource(dataSourceMap, shardingRuleConfig, props);

        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        // 6. 测试向t_order表插入8条数据，8条数据会分散到2个表
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
        DruidDataSource ds0 = createDruidDataSource("jdbc:mysql://localhost:3306/sj_ds0", "root", "ilxw");
        dataSourceMap.put("ds0", ds0);
        return dataSourceMap;
    }

    private static DruidDataSource createDruidDataSource(String jdbcUrl, String username, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // 设置其他DruidDataSource属性
        // dataSource.set...
        return dataSource;
    }


}
