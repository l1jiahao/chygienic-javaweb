package com.ncu.chygienicjavaweb.controller;


import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.UpdateUserMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/updateinform")
public class UpdateUserInformController {
    @Resource
    UpdateUserMapper updateUserMapper;

    //修改电话号码
    @RequestMapping(value ="/updatephonenumber",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject UpdateNumber(@RequestBody JSONObject jsonContent){
        String phone_number=(String)jsonContent.get("phone_number");
        Integer user_id=(Integer)jsonContent.get("user_id");

        updateUserMapper.UpdatePhoneNumber(phone_number,user_id);//更新电话号码

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","修改号码成功");
        jsonTotal.put("status",1);

        return jsonTotal;

    }

    //修改密码
    @RequestMapping(value ="/updatepassword",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject UpdatePassword(@RequestBody JSONObject jsonContent){
        String password=(String)jsonContent.get("user_password");
        Integer user_id=(Integer)jsonContent.get("user_id");

        updateUserMapper.UpdateUserPassword(password,user_id);//更新账号密码

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","修改密码成功");
        jsonTotal.put("status",1);

        return jsonTotal;
    }
}
