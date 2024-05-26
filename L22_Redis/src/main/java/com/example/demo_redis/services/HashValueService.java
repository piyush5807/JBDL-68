package com.example.demo_redis.services;

import com.example.demo_redis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HashValueService {

    /**
     * HK - Hash key (in terms of spring data redis) / Field (in terms of redis)
     * HV - Hash value (in terms of spring data redis) / Value (in terms of redis)
     *
     * A key K stores Pairs of HK and HV
     *
     * K - string
     * HK - string
     * HV - object
     */

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String REDIS_KEY_PREFIX = "person_hash::";

    private String getKey(String id){
        return REDIS_KEY_PREFIX + id;
    }

    public Person set(Person person){
        // Convert person obj --> map of field and values and then pass it to put all

        Map<String, Object> fieldValuePairs = this.objectMapper.convertValue(person, Map.class);

        this.redisTemplate.opsForHash().putAll(getKey(person.getId()), fieldValuePairs);

        return person;
    }

    public Person getPerson(String personId){

        Map map = this.redisTemplate.opsForHash().entries(getKey(personId));
        return this.objectMapper.convertValue(map, Person.class);
    }

    public Object getValueForField(String id, String field){
        return this.redisTemplate.opsForHash().get(getKey(id), field);
    }

    public void deleteField(String id, String field){
        this.redisTemplate.opsForHash().delete(getKey(id), field);
    }


    /**
     * HMGET
     * HSET
     * ...
     */
}
