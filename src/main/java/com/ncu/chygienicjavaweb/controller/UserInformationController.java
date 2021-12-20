package com.ncu.chygienicjavaweb.controller;


import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.UserInformation;
import com.ncu.chygienicjavaweb.mapper.UserPersonalMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userimformation")
public class UserInformationController {

    @Resource
    private UserPersonalMapper userPersonalMapper;

    @RequestMapping("/GetUserInformation")
    public JSONObject GetUserInformation(String account){
        UserInformation userInformation=userPersonalMapper.GetUserInformation(account);

        JSONObject jsonTotal = new JSONObject();

        if (userInformation==null){
            jsonTotal.put("status",0);//
            jsonTotal.put("message","未找到对应用户");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", userInformation);
        }
        return jsonTotal;
    }
}
