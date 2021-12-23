package com.ncu.chygienicjavaweb.controller.user;


import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.UpdateJsonMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/updateprojectinform")
public class UpdateProjectController {
    @Resource
    UpdateJsonMapper updateJsonMapper;

    //第四个接口，修改某个项目的信息
    @RequestMapping(value ="/change",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject Change(@RequestBody JSONObject jsonContent){
        Integer json_id=(Integer) jsonContent.get("json_id");
        JSONObject jsonObject=(JSONObject) jsonContent.getJSONObject("json_content");
        updateJsonMapper.UpdateUser_json(jsonObject.toJSONString(),json_id);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","修改项目信息成功");
        jsonTotal.put("status",1);

        return jsonTotal;
    }
}
