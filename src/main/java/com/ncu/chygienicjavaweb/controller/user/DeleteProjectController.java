package com.ncu.chygienicjavaweb.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.user.DeleteProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/delete")
public class DeleteProjectController {
    @Resource
    DeleteProjectMapper deleteProjectMapper;

    //对应第五个接口，删除某个项目，共需要删除三个表的记录
    @RequestMapping("/deleteproject")
    public JSONObject DeleteProject(Integer proj_id){

        //先删除json表相应的记录，再删user_project表，最后再删project表
        int i=deleteProjectMapper.DeleteUser_json(proj_id);

        int j=deleteProjectMapper.DeleteUser_project(proj_id);

        int k=deleteProjectMapper.DeleteProjectColumn(proj_id);

        int l=deleteProjectMapper.DeleteProjectAppendix(proj_id);

        JSONObject jsonTotal =new JSONObject();
        if(i==1&&j==1&k==1){
            jsonTotal.put("message","删除成功");
            jsonTotal.put("status",1);
        }
        else{
            jsonTotal.put("message","删除失败");
            jsonTotal.put("status",0);
        }

        return jsonTotal;
    }
}
