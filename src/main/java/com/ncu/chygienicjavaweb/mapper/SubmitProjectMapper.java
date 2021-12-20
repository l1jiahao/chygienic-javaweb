package com.ncu.chygienicjavaweb.mapper;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Insert;


public interface SubmitProjectMapper {

    @Insert("insert into user_json (json_content) values(#{json_content})")
    void SubmitTechProject(JSON json_content);
}
