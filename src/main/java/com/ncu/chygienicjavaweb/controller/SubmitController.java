package com.ncu.chygienicjavaweb.controller;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.SubmitProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo1")
public class SubmitController {
    @Resource
    SubmitProjectMapper submitProjectMapper;


    @RequestMapping("/demo2")
    public String Submit(JSON json_content){
        submitProjectMapper.SubmitTechProject(json_content);
        return "   fag";
    }
}
