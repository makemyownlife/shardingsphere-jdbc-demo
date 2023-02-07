package com.courage.shardingsphere.jdbc.server.sharding;

/**
 * 组合键的分片实现
 * Created by zhangyong on 2023/2/7.
 */
public class TwoCombineKeyAlgorithm extends HashSlotAlgorithm {

    private final static int TWO_COMBINE_KEY_LENGTH = 2;

    //默认是否查询id
    public String getQuerySnowFlakeIdColumn() {
        return "id";
    }

    //组合键数目 比如 sharding-columns:id,ent_id,region_code 组合键为：ent_id , region_code , 数目为 2
    public int getCombineKeyLength() {
        return TWO_COMBINE_KEY_LENGTH;
    }

}
