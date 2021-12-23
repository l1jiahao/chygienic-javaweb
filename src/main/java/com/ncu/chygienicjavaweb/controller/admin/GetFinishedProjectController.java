package com.ncu.chygienicjavaweb.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.admin.GetFinishedProject;
import com.ncu.chygienicjavaweb.mapper.admin.GetFinishedProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

//第11个接口控制层，获取某个表单中用户已填项目
@RestController
@RequestMapping("/getFinishedProject")
public class GetFinishedProjectController {

    @Resource
    GetFinishedProjectMapper getFinishedProjectMapper;
    @RequestMapping("/getAllFinishedProject")
    public JSONObject getAllFinishedProject(int limit_id){

        ArrayList<GetFinishedProject> list = getFinishedProjectMapper.getAllFinishedProject(limit_id);

        JSONArray projectJsonAry = new JSONArray();
        JSONObject jsonTotal =new JSONObject();
        //判断条件不能用list==null来判断，因为即使查询不到list也不为空，但长度为空
        if(list.size()==0){
            jsonTotal.put("status",0);
            jsonTotal.put("message","未正确选择表单类型");
        }
        else {
            projectJsonAry.addAll(list);
            jsonTotal.put("message",projectJsonAry);
            jsonTotal.put("status",1);
        }
        return jsonTotal;
    }
}
