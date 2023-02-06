package com.courage.shardingsphere.jdbc.server.sharding;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

/**
 * 复合分片算法 :
 * 主键id 是雪花算法 , workerId = crc32(shardingKey) % 1024
 */
public class HashSlotAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue complexKeysShardingValue) {
        List<Integer> slotList = new ArrayList<>();
        //真实数据库数量
        int count = availableTargetNames.size();
        //先判断是否走主键路由，若主键路由, 查询中到数据 按照主键路由 , 否则按照分表字段路由
        boolean querySnowFlakeIdOK = false;
        String querySnowFlakeIdColumn = getQuerySnowFlakeIdColumn();
        if (StringUtils.isNotBlank(querySnowFlakeIdColumn)) {
            List<String> valuesByQuerySnowFlakeId = doShardingValuesByQuerySnowFlakeId(complexKeysShardingValue);
            if (CollectionUtils.isNotEmpty(valuesByQuerySnowFlakeId)) {
                querySnowFlakeIdOK = true;
                for (String idValue : valuesByQuerySnowFlakeId) {
                    slotList.add(SnowFlakeIdGenerator.getWorkerId(Long.valueOf(idValue)));
                }
            }
        }

        //若主键路由失败,则通过分表字段路由
        if (!querySnowFlakeIdOK) {
            List<String> values = doShardingValuesByShardingColumns(complexKeysShardingValue);
            if (CollectionUtils.isNotEmpty(values)) {
                for (String value : values) {
                    int slot = StringHashUtil.hashSlot(value);
                    slotList.add(slot);
                }
            }
        }

        //返回结果
        List result = new ArrayList<>();
        for (Integer slot : slotList) {
            int index = StringHashUtil.index(slot, count);
            result.add(availableTargetNames.toArray()[index]);
        }
        return result;
    }

    public String getQuerySnowFlakeIdColumn() {
        return IdConstants.PRIMARY_KEY;
    }

    private List<String> doShardingValuesByQuerySnowFlakeId(ComplexKeysShardingValue complexKeysShardingValue) {
        String querySnowFlakeIdColumn = getQuerySnowFlakeIdColumn();
        List<String> idValues = getShardingValueListByColumn(querySnowFlakeIdColumn, complexKeysShardingValue);
        return idValues;
    }

    private List<String> doShardingValuesByShardingColumns(ComplexKeysShardingValue complexKeysShardingValue) {
        //是否是单键
        boolean singleKey = complexKeysShardingValue.getColumnNameAndShardingValuesMap().size() == 1 ? true : false;
        List<String> combinnationList = null;
        //单分片键
        if (singleKey) {
            combinnationList = doSingleSharding(complexKeysShardingValue);
        }
        //多分片键
        else {
            combinnationList = doMultiSharding(complexKeysShardingValue);
        }
        return combinnationList;
    }

    private List<String> doSingleSharding(ComplexKeysShardingValue complexKeysShardingValue) {
        List<String> shardingColumns = getShardingColumnsArray(complexKeysShardingValue);
        String shardingColumn = shardingColumns.get(0);
        List<String> valueList = getShardingValueListByColumn(shardingColumn, complexKeysShardingValue);
        return valueList;
    }

    private List<String> doMultiSharding(ComplexKeysShardingValue complexKeysShardingValue) {
        List<List<String>> collection = new ArrayList<List<String>>();
        List<String> shardingColumns = getShardingColumnsArray(complexKeysShardingValue);
        for (int i = 0; i < shardingColumns.size(); i++) {
            String shardingColumn = shardingColumns.get(i);
            List<String> shardingValueList = getShardingValueListByColumn(shardingColumn, complexKeysShardingValue);
            if (shardingValueList != null && shardingValueList.size() > 0) {
                collection.add(shardingValueList);
            }
        }
        //若所有的分区键都有值的情况下 才会进行笛卡尔积组合
        if (collection.size() == shardingColumns.size()) {
            return StringHashUtil.descartes(collection);
        }
        return Collections.EMPTY_LIST;
    }

    private List<String> getShardingValueListByColumn(String shardingColumn, ComplexKeysShardingValue complexKeysShardingValue) {
        List<String> arrayList = new ArrayList<String>(1);
        //先处理这个值
        Map<String, Collection> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        columnNameAndShardingValuesMap.forEach((key, values) -> {
            if (shardingColumn.equals(key)) {
                for (Object value : values) {
                    if (value != null) {
                        arrayList.add(String.valueOf(value));
                    }
                }
            }
        });
        return arrayList;
    }

    private List<String> getShardingColumnsArray(ComplexKeysShardingValue complexKeysShardingValue) {
        Map<String, Collection> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        int size = columnNameAndShardingValuesMap.size();
        List<String> arr = new ArrayList<String>(size);
        columnNameAndShardingValuesMap.forEach((key, values) -> {
            arr.add(key);
        });
        return arr;
    }

}
