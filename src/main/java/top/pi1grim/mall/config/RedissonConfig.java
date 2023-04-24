package top.pi1grim.mall.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.data.redis.password}")
    private String password;


    private final String[] nodes = {
            "redis://101.42.30.159:6371",
            "redis://101.42.30.159:6372",
            "redis://101.42.30.159:6373",
            "redis://101.42.30.159:6374",
            "redis://101.42.30.159:6375",
            "redis://101.42.30.159:6376"
    };

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress(nodes)
                .setPassword(password);
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }

}
