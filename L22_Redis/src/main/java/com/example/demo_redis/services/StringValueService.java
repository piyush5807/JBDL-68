package com.example.demo_redis.services;

import com.example.demo_redis.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StringValueService {

    private static final String REDIS_KEY_PREFIX = "person::";
    private static final Long REDIS_KEY_EXPIRY = 10l;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private String getKey(String id){
        return REDIS_KEY_PREFIX + id;
    }

    public Person create(Person p){
        this.redisTemplate.opsForValue().set(getKey(p.getId()), p, REDIS_KEY_EXPIRY, TimeUnit.MINUTES);
        return p;
    }

    public Person get(String personId) {
        return (Person) this.redisTemplate.opsForValue().get(getKey(personId));
    }


    /**
     * TTL
     * EXPIRE , PEXPIRE
     * EXPIREAT , PEXPIREAT
     * INCR, DECR
     */
}
