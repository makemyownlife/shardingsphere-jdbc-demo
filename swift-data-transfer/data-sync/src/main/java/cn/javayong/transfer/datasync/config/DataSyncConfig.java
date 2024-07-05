package cn.javayong.transfer.datasync.config;

import java.util.HashMap;
import java.util.Map;

public class DataSyncConfig {

    private HashMap<String, HashMap<String, Object>> fullStrategy = new HashMap<String, HashMap<String, Object>>();

    public HashMap<String, HashMap<String, Object>> getFullStrategy() {
        return fullStrategy;
    }

    public void setFullStrategy(HashMap<String, HashMap<String, Object>> fullStrategy) {
        this.fullStrategy = fullStrategy;
    }

}
