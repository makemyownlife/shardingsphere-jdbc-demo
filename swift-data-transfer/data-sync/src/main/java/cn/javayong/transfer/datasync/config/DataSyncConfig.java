package cn.javayong.transfer.datasync.config;

import java.util.HashMap;
import java.util.Map;

public class DataSyncConfig {

    private HashMap<String, HashMap<String, Object>> fullStrategy = new HashMap<String, HashMap<String, Object>>();

    // =========================================== 全量配置 start =======================================================
    public HashMap<String, HashMap<String, Object>> getFullStrategy() {
        return fullStrategy;
    }

    public void setFullStrategy(HashMap<String, HashMap<String, Object>> fullStrategy) {
        this.fullStrategy = fullStrategy;
    }

    // =========================================== 全量配置 end  =======================================================

    // =========================================== 增量配置 start =======================================================

    private HashMap<String, HashMap<String, Object>> incrStrategy = new HashMap<String, HashMap<String, Object>>();

    public HashMap<String, HashMap<String, Object>> getIncrStrategy() {
        return incrStrategy;
    }

    public void setIncrStrategy(HashMap<String, HashMap<String, Object>> incrStrategy) {
        this.incrStrategy = incrStrategy;
    }

// =========================================== 增量配置 end  =======================================================

}
