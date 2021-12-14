package com.ncu.chygienicjavaweb.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.User;
import com.ncu.chygienicjavaweb.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author nogra
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/getOne")
    public JSONObject getOne(int id){
        User user = userMapper.getOne(id);

        JSONObject jsonTotal = new JSONObject();

        if (user==null){
            jsonTotal.put("status",0);
            jsonTotal.put("message","未找到对应用户");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", user);
        }
        return jsonTotal;
    }

    @RequestMapping("/getAll")
    public JSONObject getAll(){
        ArrayList<User> users = userMapper.getAll();

        JSONArray userJsonAry = new JSONArray();
        userJsonAry.addAll(users);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message",userJsonAry);
        jsonTotal.put("status",1);

        return jsonTotal;
    }

}
