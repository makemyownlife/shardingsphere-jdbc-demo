package cn.javayong.transfer.datasync.config;

import java.util.HashMap;
import java.util.Map;

public class DataSyncConfig {

    private HashMap<String, HashMap<String, String>> fullStrategy = new HashMap<String, HashMap<String, String>>();

    public HashMap<String, HashMap<String, String>> getFullStrategy() {
        return fullStrategy;
    }

    public void setFullStrategy(HashMap<String, HashMap<String, String>> fullStrategy) {
        this.fullStrategy = fullStrategy;
    }

}
