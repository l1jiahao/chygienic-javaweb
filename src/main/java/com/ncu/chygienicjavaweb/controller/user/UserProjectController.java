package com.ncu.chygienicjavaweb.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.UserProject;
import com.ncu.chygienicjavaweb.mapper.GetUserProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/get")
public class UserProjectController {
    @Resource
    GetUserProjectMapper getUserProjectMapper;

    //对应第二个接口，获取用户已经填报的所有项目
    @RequestMapping("/getuserproject")
    public JSONObject GetProject(Integer user_id){

        ArrayList<UserProject> list=getUserProjectMapper.GetUserAllProject(user_id);

        JSONArray projectJsonAry = new JSONArray();
        JSONObject jsonTotal =new JSONObject();
        //判断条件不能用list==null来判断，因为即使查询不到list也不为空，但长度为空
        if(list.size()==0){
            jsonTotal.put("status",0);
            jsonTotal.put("message","未找到对应用户");
        }
        else {
            projectJsonAry.addAll(list);
            jsonTotal.put("message",projectJsonAry);
            jsonTotal.put("status",1);
        }
        return jsonTotal;
    }


}
