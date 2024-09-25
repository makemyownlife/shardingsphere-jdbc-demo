package cn.javayong.shardingjdbc4.spring.common.sharding;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 分表策略
 * HashSlotAlgorithm 32 表
 */
public class HashSlotAlgorithmTables extends HashSlotAlgorithmDatabase{

    ConsistentHashingTables consistentHashingTables = new ConsistentHashingTables();

    /**
     * 分片策略
     *
     * @param availableTargetNames available data sources or tables's names 发挥的是多少个库，t_ent_order_detail0-31
     * @param complexKeysShardingValue {@link ComplexKeysShardingValue} ex: ComplexKeysShardingValue(logicTableName=t_ent_order, columnNameAndShardingValuesMap={id=[674988670850883591]}, columnNameAndRangeValuesMap={})
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue complexKeysShardingValue) {
        consistentHashingTables.init(new ArrayList<>(availableTargetNames), 1);
        return getSharding(availableTargetNames, complexKeysShardingValue, consistentHashingTables);
    }

}
