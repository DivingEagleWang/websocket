package com.test.websockettest.controller;

import com.alibaba.fastjson.JSON;
import com.test.websockettest.domain.Student;
import com.test.websockettest.server.RedisService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangli
 * 2019/11/11  10:40
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;
    @PostMapping("/setRedis")
    public String set(@RequestParam String key, @RequestBody Student student){
        System.out.println("前台传来的数据："+student.toString());
        redisService.set(key,student);
        return "ok";
    }
    @DeleteMapping("/deleteRedis")
    public Boolean deleteRedis(@RequestParam String key){
        return redisService.delete(key);
    }
    @PostMapping("/hasRedis")
    public boolean hasRedis(@RequestParam String key){
        return redisService.hasKey(key);
    }
    @GetMapping("/getRedis")
    public Object get(@RequestParam String studentKey){
        System.out.println("前台传来的的数据："+studentKey);
        Student student = JSON.parseObject(redisService.get(studentKey), Student.class);
        return student;
    }
}
