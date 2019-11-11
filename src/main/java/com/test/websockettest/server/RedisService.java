package com.test.websockettest.server;

import com.test.websockettest.domain.Student;

import java.util.List;

/**
 * Created by wangli
 * 2019/11/11  10:22
 */
public interface RedisService {
    void set (String key, Object value);
    Boolean delete(String key);
    Boolean hasKey(String key);
    String get(String key);
    void multiSet (String key, List<Student> list);
}
