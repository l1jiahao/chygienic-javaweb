package com.ncu.chygienicjavaweb.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.admin.UpdateStatusMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//第13个接口控制层，修改某个项目的状态
@RestController
@RequestMapping("/update")
public class UpdateStatusController {
    @Resource
    UpdateStatusMapper updateStatusMapper;

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject updateStatus(@RequestBody JSONObject jsonContent){
        Integer proj_id=(Integer) jsonContent.get("proj_id");
        Integer status=(Integer) jsonContent.get("status");
        updateStatusMapper.updateOneStatus(proj_id,status);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","修改项目状态成功");
        jsonTotal.put("status",1);

        return jsonTotal;
    }
}
