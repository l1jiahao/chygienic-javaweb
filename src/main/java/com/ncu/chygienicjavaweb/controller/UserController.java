package com.ncu.chygienicjavaweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
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
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("getAllUsers")
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
