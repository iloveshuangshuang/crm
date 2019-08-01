package com.whir.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 字符串存储
     */
    public void save(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 字符串存储带时间
     */
    public void save(String key, Object value, Long expire, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,expire,timeUnit);
    }

    /**
     * 获取value
     * @param key
     */
    public Object getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * List集合
     * @param key
     * @param value
     */
    public void saveList(String key,Object value){
        redisTemplate.opsForList().leftPush(key,value);
    }
    public List getList(String key, int start, int end){
        return redisTemplate.opsForList().range(key,start,end);
    }
}
