package com.courage.shardingsphere.jdbc.server.sharding;

public class IdConstants {

    //系统默认最大分区数
    public static final int SHARDING_LENGTH = 1024;

    //表分区列表
    private static final int PARTITION_LENGTH = IdConstants.SHARDING_LENGTH;

    // %转换为&操作的换算数值
    public static final long AND_VALUE = PARTITION_LENGTH - 1;

    public static final long STEP_LENGTH = 10;

    public static final int SEQ_EXPIRE_TIME = 60;

    public final static int MAX_SEQ = 4095;

    public final static String ID_REDIS_PFEFIX = "space:idGenerator:";

}
