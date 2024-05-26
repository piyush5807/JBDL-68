package com.example.demo_redis.configs;

import com.example.demo_redis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

    @Bean
    ObjectMapper getMapper(){
        return new ObjectMapper();
    }

    @Bean
    RedisConnectionFactory getConnection(){

        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration(
                "redis-12328.c330.asia-south1-1.gce.redns.redis-cloud.com", 12328
        );

        standaloneConfiguration.setPassword("m5T0OAprpEmhzSKxjKQKzISbmQFglLgI");

        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(standaloneConfiguration);
        return lettuceConnectionFactory;
    }

    /**
     * K - data type of the key (Person as the key) {person --> string}
     * V - data type of the value (Person as the value) { person --> string, list <string>, string}
     * @return
     */

    @Bean
    public RedisTemplate<String, Object> getTemplate(){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getConnection());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }

}
