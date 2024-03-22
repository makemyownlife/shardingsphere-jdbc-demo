package cn.javayong.shardingjdbc5.spring.common.sharding;

import cn.javayong.shardingbase.ShardingConstants;
import cn.javayong.shardingbase.SnowFlakeIdGenerator;
import cn.javayong.shardingbase.StringHashUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 复合分片算法 :
 * 主键id 是雪花算法 workerId = crc32(shardingKey) % 1024
 */
public class HashSlotAlgorithm implements ComplexKeysShardingAlgorithm {

    public final static Logger logger = LoggerFactory.getLogger(HashSlotAlgorithm.class);

    // 是否直接通过 slot/shardingCount
    private final static String DIRECT_INDEX_PROPERTY = "directIndex";

    private Properties properties;

    @Override
    public void init(Properties properties) {
        logger.info("begin to init HashSlotAlgorithm ");
        this.properties = properties;
    }

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue complexKeysShardingValue) {
        List<Integer> slotList = new ArrayList<>();
        // 真实分片数量
        int count = availableTargetNames.size();
        if ((count & (count - 1)) != 0) {
            throw new RuntimeException("分区数必须是2的次幂,当前分区数是:" + count) {
            };
        }
        // 先判断是否走主键路由，若主键路由, 查询中到数据 按照主键路由 , 否则按照分表字段路由
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
        // 若主键路由失败 , 则通过分片组合字段路由
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
            Integer index = null;
            if (StringUtils.equals("true", properties.getProperty(DIRECT_INDEX_PROPERTY))) {
                index = StringHashUtil.indexDirect(slot, count);
            } else {
                index = StringHashUtil.index(slot, count);
            }
            result.add(availableTargetNames.toArray()[index]);
        }
        return result;
    }

    //默认是否查询id
    public String getQuerySnowFlakeIdColumn() {
        return ShardingConstants.DEFAULT_PRIMARY_KEY;
    }

    //组合键数目 比如 sharding-columns:id,ent_id,region_code 组合键为：ent_id , region_code , 数目为 2
    public int getCombineKeyLength() {
        return ShardingConstants.DEFAULT_SINGLE_COMBINE_KEY_LENGTH;
    }

    private List<String> doShardingValuesByQuerySnowFlakeId(ComplexKeysShardingValue complexKeysShardingValue) {
        String querySnowFlakeIdColumn = getQuerySnowFlakeIdColumn();
        List<String> idValues = getShardingValueListByColumn(querySnowFlakeIdColumn, complexKeysShardingValue);
        return idValues;
    }

    private List<String> doShardingValuesByShardingColumns(ComplexKeysShardingValue complexKeysShardingValue) {
        int combineKeyLength = getCombineKeyLength();
        List<String> shardingColumnsArray = getShardingColumnsArray(complexKeysShardingValue);
        if (shardingColumnsArray.size() != combineKeyLength) {
            return Collections.EMPTY_LIST;
        }
        List<String> combinnationList = null;
        //单分片键
        if (combineKeyLength == ShardingConstants.DEFAULT_SINGLE_COMBINE_KEY_LENGTH) {
            combinnationList = doSingleSharding(complexKeysShardingValue, shardingColumnsArray);
        }
        //多分片键
        else {
            combinnationList = doMultiSharding(complexKeysShardingValue, shardingColumnsArray);
        }
        return combinnationList;
    }

    private List<String> doSingleSharding(ComplexKeysShardingValue complexKeysShardingValue, List<String> shardingColumnsArray) {
        String shardingColumn = shardingColumnsArray.get(0);
        List<String> valueList = getShardingValueListByColumn(shardingColumn, complexKeysShardingValue);
        return valueList;
    }

    private List<String> doMultiSharding(ComplexKeysShardingValue complexKeysShardingValue, List<String> shardingColumnsArray) {
        List<List<String>> collection = new ArrayList<List<String>>();
        for (int i = 0; i < shardingColumnsArray.size(); i++) {
            String shardingColumn = shardingColumnsArray.get(i);
            List<String> shardingValueList = getShardingValueListByColumn(shardingColumn, complexKeysShardingValue);
            if (shardingValueList != null && shardingValueList.size() > 0) {
                collection.add(shardingValueList);
            }
        }
        return StringHashUtil.descartes(collection);
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
        //对分区键做一个排序，便于后续实现笛卡尔积
        Collections.sort(arr);
        return arr;
    }

}
