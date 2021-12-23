package com.ncu.chygienicjavaweb.controller;


import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.submitproject.Project;
import com.ncu.chygienicjavaweb.entity.submitproject.UserJson;
import com.ncu.chygienicjavaweb.mapper.SubmitProjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/demo1")
public class SubmitController {

    @Resource
    SubmitProjectMapper submitProjectMapper;

    @RequestMapping(value ="/demo2",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject Submit(@RequestBody JSONObject jsonContent){
        //
        Integer user_id=(Integer) jsonContent.get("user_id");
        String proj_name=(String)jsonContent.get("proj_name");
        Integer proj_type_id=(Integer)jsonContent.get("proj_type_id");
        JSONObject jsonObject=(JSONObject)jsonContent.getJSONObject("json_content");//获取
        Integer limit_id=(Integer)jsonContent.get("limit_id");
        String appendix=(String)jsonContent.get("appendix");
        //
        UserJson userJson=new UserJson();//创建userjson对象，存user_json表，并获取到表的id，该id可用于存下一个project表
        userJson.setJson_content(jsonObject.toJSONString());

        //这里执行的是插入user_json表的方法
        submitProjectMapper.SubmitTechProject(userJson);
        int json_id=userJson.getJson_id();//获取到json表的id


        //这里代码比较繁琐，可以用构造方法，但我先用set方法
        Project project=new Project();

        project.setAppendix(appendix);
        project.setProject_name(proj_name);
        project.setJson_id(json_id);
        project.setProject_type_id(proj_type_id);
        project.setLimit_id(limit_id);

        //存user_project表
        submitProjectMapper.SubmitProject(project);
        int project_id=project.getId();//project表项id

        submitProjectMapper.SubmitUserProject(user_id,project_id);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","填报成功");
        jsonTotal.put("status",1);

        return jsonTotal;



    }


}
