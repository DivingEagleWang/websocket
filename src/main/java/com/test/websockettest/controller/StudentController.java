package com.test.websockettest.controller;

import com.test.websockettest.domain.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangli
 * 2019/10/30  10:18
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 测试接受List集合
     * @param students
     * @return
     */
    @PostMapping("/multiple")
    public String getMultiple(@RequestBody List<Student> students){
        return students.toString();
    }
}
