package com.ncu.chygienicjavaweb.controller.user;


import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.UserInformation;
import com.ncu.chygienicjavaweb.mapper.LoginMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginMapper loginMapperMapper;

    //对应第一个接口，登录，返回用户user表相关信息,对应要查三个表
    @RequestMapping(value ="/GetUserInformation",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject GetUserInformation(@RequestBody JSONObject jsonContent){
        String account=(String) jsonContent.get("account");
        String password=(String)jsonContent.get("password");

        UserInformation userInformation=loginMapperMapper.GetUserInformation(account,password);

        JSONObject jsonTotal = new JSONObject();

        if (userInformation==null){
            jsonTotal.put("status",0);//
            jsonTotal.put("message","密码或账号错误");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", userInformation);
        }
        return jsonTotal;
    }
}
