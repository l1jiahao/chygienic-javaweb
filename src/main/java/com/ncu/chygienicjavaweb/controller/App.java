package com.ncu.chygienicjavaweb.controller;

import com.ncu.chygienicjavaweb.entity.User;
import com.ncu.chygienicjavaweb.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class App {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/getall")
    public List<User> getAll(){
        List<User> users = userMapper.getAll();
        return users;
    }
}
