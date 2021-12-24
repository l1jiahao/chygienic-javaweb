package com.ncu.chygienicjavaweb.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.submitproject.UserJson;
import com.ncu.chygienicjavaweb.mapper.user.GetoneProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
@RequestMapping("/Getone")
public class GetoneProjectController {
    @Resource
    GetoneProjectMapper getoneProjectMapper;

    @RequestMapping("/get")
    public JSONObject get(Integer proj_id){
        UserJson userJson=new UserJson();
        userJson=getoneProjectMapper.GetOneProject(proj_id);
        //
        String test=userJson.getJson_content();
        JSONObject jsonStr = JSONObject.parseObject(test);
        //
        JSONObject jsonTotal = new JSONObject();

        if (userJson==null){
            jsonTotal.put("status",0);
            jsonTotal.put("message","未找到对应用户");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", userJson);
        }
        /*
        返回的jsonTotal中，json_content中出现了反斜杠，在每个双引号的前面加了反斜杠表示转义
        原因是：在出现多余斜杠的json序列中，一部分json子对象没有以子对象的形式存在，而是以一个 表达json对象的字符串 的形式存在，
        从内容上来说我们认为它是一个子对象，然而数据上来说它是一个字符串，
        由于这个字符串表达了一个 json 序列，于是这个字符串中会存在双引号，
        因此为了在字符串中表达双引号这个字符，它在打印时被携带了前置的转义反斜杠
         */
        JSONObject jsonObject=(JSONObject)jsonTotal.getJSONObject("message");
        jsonObject.put("json_content",jsonStr);
        jsonTotal.put("message",jsonObject);

        return jsonTotal;
    }
}
