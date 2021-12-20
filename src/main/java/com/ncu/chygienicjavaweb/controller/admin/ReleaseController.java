package com.ncu.chygienicjavaweb.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.admin.ReleaseMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/release")
public class ReleaseController {
    @Resource
    private ReleaseMapper releaseMapper;

    //管理员发布表格
    @RequestMapping(value ="/addRelease",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void save(@RequestBody JSONObject jsonContent) {
        releaseMapper.insert(jsonContent.getString("limit_column"));
    }



}
