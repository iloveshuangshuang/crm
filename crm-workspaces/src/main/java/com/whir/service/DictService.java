package com.whir.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whir.mapper.DictMapper;
import com.whir.model.Dict;
import com.whir.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService{

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    RedisUtils redisUtils;

    public List<Dict> find(String id){
        return dictMapper.find(id);
    }

    //从redis数据库中查询
    public String findById(String id) {
        //String dict = redisTemplate.opsForValue().get(id);
        boolean haskey= redisTemplate.hasKey(id);
        //如果key存在，从缓存数据库取
        if (haskey) {
            String dict = redisTemplate.opsForValue().get(id);
            String a = dict.substring(1, dict.length()-1);//去掉开头和结尾的双引号
            String b = a.replace("\\", "");//去掉转义字符
            System.out.println("从redis缓存中获取="+b);
            return dict;
        }
        //如果不存在，从mysql取，并转换为json格式
        List<Dict> list = dictMapper.find(id);
        System.out.println("从mysql数据库中获取list="+list);
        String json = JSON.toJSONString(list);
        System.out.println("从mysql数据库中获取json="+json);
        //将这个key和value插入redis
        if(json!=null){
            redisUtils.save(id,json);
            System.out.println("存入redis数据库");
        }

        return json;
    }
}
