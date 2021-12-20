package com.ncu.chygienicjavaweb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.PersonalAppQuery;
import com.ncu.chygienicjavaweb.entity.User;
import com.ncu.chygienicjavaweb.mapper.PersonalAppQueryMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/personalAppQuery")
public class PersonalAppQueryController {
    @Resource
    private PersonalAppQueryMapper personalAppQueryMapper;

    @RequestMapping("/getWaitOne")
    public JSONObject getWaitOne(int id){
        PersonalAppQuery personalAppQuery = personalAppQueryMapper.getWaitOne(id);

        JSONObject jsonTotal = new JSONObject();

        if (personalAppQuery==null){
            jsonTotal.put("status",0);
            jsonTotal.put("message","不存在未审核的项目");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", personalAppQuery);
        }
        return jsonTotal;
    }

    @RequestMapping("/getWaitAll")
    public JSONObject getWaitAll(){
        ArrayList<PersonalAppQuery> PSW = personalAppQueryMapper.getWaitAll();

        JSONArray pswJsonAry = new JSONArray();
        pswJsonAry.addAll(PSW);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message",pswJsonAry);
        jsonTotal.put("status",1);

        return jsonTotal;
    }

    @RequestMapping("/getPassOne")
    public JSONObject getPassOne(int id){
        PersonalAppQuery personalAppQuery = personalAppQueryMapper.getPassOne(id);

        JSONObject jsonTotal = new JSONObject();

        if (personalAppQuery==null){
            jsonTotal.put("status",0);
            jsonTotal.put("message","不存在已通过的项目");
        }
        else {
            jsonTotal.put("status", 1);
            jsonTotal.put("message", personalAppQuery);
        }
        return jsonTotal;
    }

    @RequestMapping("/getPassAll")
    public JSONObject getPassAll(){
        ArrayList<PersonalAppQuery> PSP = personalAppQueryMapper.getPassAll();

        JSONArray pspJsonAry = new JSONArray();
        pspJsonAry.addAll(PSP);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message",pspJsonAry);
        jsonTotal.put("status",1);

        return jsonTotal;
    }
}
