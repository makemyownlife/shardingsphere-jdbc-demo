package com.courage.shardingsphere.jdbc.server;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.courage.shardingsphere.jdbc.domain.mapper")
@SpringBootApplication(scanBasePackages = {"com.courage.shardingsphere.jdbc"})
public class MainApplication {

    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        //dubbo 默认日志走log4j 启动做一点调整
        System.setProperty("dubbo.application.logger", "slf4j");
        SpringApplication.run(MainApplication.class, args);
        logger.info("        >>>>>>>>服务启动成功，开启新的征程<<<<<<<<        ");
    }

}
