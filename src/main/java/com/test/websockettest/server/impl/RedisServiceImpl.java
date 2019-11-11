package com.test.websockettest.server.impl;

import com.alibaba.fastjson.JSON;
import com.test.websockettest.domain.Student;
import com.test.websockettest.server.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangli
 * 2019/11/11  10:29
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    // 存数据
    @Override
    public void set(String key, Object value) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        // 转换成json对象
        String s = JSON.toJSONString(value);
        vo.set(key,s);  //存入redis中
        redisTemplate.expire(key,100, TimeUnit.SECONDS); //设置该key100s之后失效
    }
    // 删除key
    @Override
    public Boolean delete(String key) {
        Boolean delete = false;
        if(StringUtils.isNotBlank(key)){
            delete = redisTemplate.delete(key);
        }
        return delete;
    }
    // 判断是否有key
    @Override
    public Boolean hasKey(String key) {
        Boolean hasKey = false;
        if(StringUtils.isNotBlank(key)){
            hasKey = redisTemplate.hasKey(key);
        }
        return hasKey;
    }
    // 获得key
    @Override
    public String get(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        String s = vo.get(key);
        return s;
    }

    @Override
    public void multiSet(String key, List<Student> list) {
        ListOperations ops = redisTemplate.opsForList();
//        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
//        HashMap<String, Student> map = new HashMap<>();
//        for(Student stu: list){
//
//        }
//        vo.multiSet();
////        JSONArray.parseObject()
//        redisTemplate.expire(key,100, TimeUnit.SECONDS); //设置该key100s之后失效
    }
}
