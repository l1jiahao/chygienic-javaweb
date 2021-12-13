package com.ncu.chygienicjavaweb.controller;

import com.ncu.chygienicjavaweb.entity.Student;
import com.ncu.chygienicjavaweb.mapper.StudentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class App {
    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("/getall")
    public ArrayList<Student> getStudents(){
        return studentMapper.getAll();
    }
}
