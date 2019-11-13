package com.test.websockettest.controller;

import com.alibaba.fastjson.JSON;
import com.test.websockettest.domain.Question;
import com.test.websockettest.domain.Student;
import com.test.websockettest.server.RedisService;
import com.test.websockettest.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;

/**
 * Created by wangli
 * 2019/11/13  9:28
 */
@RestController
@RequestMapping("/axios")
@Slf4j
public class AxiosController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/testGet")
    public Object testGet(@RequestParam(required = false) Integer id){
        if(id == null){
            id=0;
        }
        log.info("来到testGet,id="+id);
        Student student = new Student();
        student.setName("测试");
        student.setAge(21);
        return student;
    }
    @PostMapping("/setQ")
    public Object testPost(@RequestBody(required = false) Question question){
        if(question != null){
            System.out.println("来到testPost,对象："+ question.toString());
            //保存在redis中
//            String key = UUIDUtil.getUUID();
            String key = String.valueOf(System.currentTimeMillis());
            redisService.set(key,question);
            if(redisService.hasKey(key)){
                return key;
            }
            return "error";
        }
        log.error("setQ,前台传来的对象为null");
        return "error";
    }
    @GetMapping("/getQ")
    public Object getQ(@RequestParam(required = false) String qid){
        if(qid != null){
            String s = redisService.get(qid);
            Question question = JSON.parseObject(s, Question.class);
            log.info("redis中取出："+question);
            return question;
        }
        return null;
    }
}
