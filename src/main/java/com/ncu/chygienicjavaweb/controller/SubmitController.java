package com.ncu.chygienicjavaweb.controller;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.mapper.SubmitProjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/demo1")
public class SubmitController {
    @Resource
    SubmitProjectMapper submitProjectMapper;


    @RequestMapping(value ="/demo2",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String Submit(@RequestBody JSONObject jsonContent){

        submitProjectMapper.SubmitTechProject(jsonContent.toJSONString());
        return "   fag";
    }
}
