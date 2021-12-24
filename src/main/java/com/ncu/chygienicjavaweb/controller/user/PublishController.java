package com.ncu.chygienicjavaweb.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.LimitColumn;
import com.ncu.chygienicjavaweb.mapper.PublishMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/publish")
public class PublishController {
    @Resource
    PublishMapper publishMapper;


    //对应第十个接口，存入两个表
    @RequestMapping(value ="/publishcolumn",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject PublishColumn(@RequestBody JSONObject jsonContent){

        String proj_batch_name=(String)jsonContent.get("proj_batch_name") ;
        JSONObject jsonObject=(JSONObject) jsonContent.getJSONObject("limit_column");
        Integer proj_type_id=(Integer)jsonContent.get("proj_type_id") ;
        String establish_time=(String) jsonContent.get("establish_time");
        String establish_end_time=(String) jsonContent.get("establish_end_time");

        //要把establish_time等获取到，（转换为String类型），再把这个转换回LocalDataTime类型
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start= LocalDateTime.parse(establish_time, formatter);
        LocalDateTime end= LocalDateTime.parse(establish_end_time, formatter);

        LimitColumn limitColumn=new LimitColumn();
        limitColumn.setLimit_columns(jsonObject.toJSONString());

        publishMapper.InsertLimitColumn(limitColumn);
        int limit_id=limitColumn.getLimit_id();

        publishMapper.InsertProjectBatch(limit_id,proj_batch_name,proj_type_id,start,end);

        JSONObject jsonTotal =new JSONObject();
        jsonTotal.put("message","发布成功");
        jsonTotal.put("status",1);

        return jsonTotal;

    }
}
