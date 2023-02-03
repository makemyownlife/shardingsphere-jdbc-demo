package com.courage.shardingsphere.jdbc.server.config;

import com.iflytek.training.framework.redis.PlatformRedisClient;
import com.iflytek.training.framework.redis.command.*;
import com.iflytek.training.framework.redis.config.PlatformSentinelServersConfig;
import com.iflytek.training.framework.redis.config.PlatformSingleServerConfig;
import com.iflytek.training.framework.redis.utils.ConfigBuilder;
import com.iflytek.training.framework.redis.utils.IdGenerator;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * redis 加载配置
 * Created by zhangyong on 2020/10/21.
 */
@Configuration
public class RedisConfig {

    @Configuration
    @ConditionalOnMissingBean(Config.class)
    @ConditionalOnProperty(name = "spring.redis.type", havingValue = "single")
    static class StaticBuildSingleServer {

        @Bean(value = "platformSingleServerConfig")
        @ConfigurationProperties(prefix = "spring.redis.single")
        public PlatformSingleServerConfig getPlatformSingleServerConfig() {
            PlatformSingleServerConfig config = new PlatformSingleServerConfig();
            return config;
        }

        @Bean
        public Config singleServerConfig(PlatformSingleServerConfig platformSingleServerConfig) {
            return ConfigBuilder.buildBySingleServerConfig(platformSingleServerConfig);
        }

        @Bean(destroyMethod = "shutdown")
        public PlatformRedisClient platformRedisClient(Config config) {
            PlatformRedisClient platformRedisClient = new PlatformRedisClient(config);
            return platformRedisClient;
        }

    }

    @Configuration
    @ConditionalOnMissingBean(Config.class)
    @ConditionalOnProperty(name = "spring.redis.type", havingValue = "sentinel")
    static class StaticBuildSentinelServer {

        @Bean(value = "platformSentinelServerConfig")
        @ConfigurationProperties(prefix = "spring.redis.sentinel")
        public PlatformSentinelServersConfig getPlatformSentinelServersConfig() {
            PlatformSentinelServersConfig platformSentinelServersConfig = new PlatformSentinelServersConfig();
            return platformSentinelServersConfig;
        }

        @Bean
        public Config sentinelServerConfig(PlatformSentinelServersConfig platformSentinelServersConfig) {
            return ConfigBuilder.buildBySentinelServerConfig(platformSentinelServersConfig);
        }

        @Bean(destroyMethod = "shutdown")
        public PlatformRedisClient platformRedisClient(Config config) {
            PlatformRedisClient platformRedisClient = new PlatformRedisClient(config);
            return platformRedisClient;
        }

    }


    @Bean("platformStringCommand")
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformStringCommand createPlatformStringCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformStringCommand();
    }

    @Bean
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformZSetCommand createPlatformZSetCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformZSetCommand();
    }

    @Bean
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformSetCommand createPlatformSetCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformSetCommand();
    }

    @Bean
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformAtomicCommand createPlatformAtomicCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformAtomicCommand();
    }

    @Bean
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformHashCommand createPlatformHashCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformHashCommand();
    }

    @Bean
    @ConditionalOnBean(PlatformRedisClient.class)
    public PlatformScriptCommand createPlatformScriptCommand(PlatformRedisClient platformRedisClient) {
        return platformRedisClient.getPlatformScriptCommand();
    }

    @Bean
    @Primary
    @ConditionalOnBean(PlatformRedisClient.class)
    public IdGenerator createIdGenerator(PlatformRedisClient platformRedisClient) {
        return new IdGenerator(platformRedisClient);
    }

}
