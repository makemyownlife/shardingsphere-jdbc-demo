package cn.javayong.transfer.datasync;

import cn.javayong.transfer.datasync.config.DataSyncConfig;
import cn.javayong.transfer.datasync.support.YamlLoader;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 同步服务主函数
 * Created by zhangyong on 2024/6/15.
 */
public class MainApplication {

    private final static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        logger.info("开始启动同步服务");
        long start = System.currentTimeMillis();

        // 加载配置
        DataSyncConfig dataSyncConfig = YamlLoader.loadConfig();
        logger.info("dataSyncConfig:" + JSON.toJSONString(dataSyncConfig));



        logger.info("结束启动同步服务 耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}