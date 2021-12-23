package com.ncu.chygienicjavaweb.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.admin.PassProjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

//第12个接口控制层，审核项目
@RestController
@RequestMapping("/pass")
public class PassProjectController {
    @Resource
    PassProjectMapper passProjectMapper;

    @RequestMapping(value = "/passAllProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject passAllProject(@RequestBody JSONObject ids) {
        ArrayList<Integer> submitIds = (ArrayList<Integer>) ids.get("proj_ids");
        for (int id : submitIds) {
            passProjectMapper.passOneProject(id);
        }

        JSONObject jsonTotal = new JSONObject();
        jsonTotal.put("message", "审核通过完成");
        jsonTotal.put("status", 1);

        return jsonTotal;
    }

    @RequestMapping(value = "/notpassAllProject", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject notpassAllProject(@RequestBody JSONObject ids) {
        ArrayList<Integer> submitIds = (ArrayList<Integer>) ids.get("proj_ids");
        for (int id : submitIds) {
            passProjectMapper.notpassOneProject(id);
            System.out.println(id);
        }

        JSONObject jsonTotal = new JSONObject();
        jsonTotal.put("message", "审核不通过完成");
        jsonTotal.put("status", 1);

        return jsonTotal;
    }
}
