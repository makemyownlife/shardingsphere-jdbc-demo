package cn.javayong.transfer.datasync.support;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class YamlLoader {

    private final static String CONFIG_FILE_NAME = "config.yml";

    public static DataSyncConfig loadConfig() {
        Yaml yaml = new Yaml();
        InputStream inputStream = YamlLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        return yaml.loadAs(inputStream, DataSyncConfig.class);
    }

}
