package com.example.minorproject1.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

public class CacheRepository<T> {
    private static final String STUDENT_KEY_PREFIX = "std::";
    private static final Long STUDENT_KEY_EXPIRY = 3600l;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void add(T t){
//        String key = this.getKey(t.getId());
//        this.redisTemplate.opsForValue().set(key, t, STUDENT_KEY_EXPIRY, TimeUnit.SECONDS);
    }

    public T get(Integer studentId){
        String key = this.getKey(studentId);
        return (T) this.redisTemplate.opsForValue().get(key);
    }

    private String getKey(Integer studentId){
        return STUDENT_KEY_PREFIX + studentId;
    }
}