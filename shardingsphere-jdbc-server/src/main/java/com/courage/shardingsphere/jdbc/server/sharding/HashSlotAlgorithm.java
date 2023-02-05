package com.courage.shardingsphere.jdbc.server.sharding;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 复合分片算法 :
 * 主键id 是雪花算法 , workerId = Math.abs(crc32(shardingKey)) % 1024
 */
public class HashSlotAlgorithm implements ComplexKeysShardingAlgorithm {

    private final static Logger logger = LoggerFactory.getLogger(HashSlotAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection collection, ComplexKeysShardingValue complexKeysShardingValue) {
        String logicTableName = complexKeysShardingValue.getLogicTableName();
        return null;
    }

}
