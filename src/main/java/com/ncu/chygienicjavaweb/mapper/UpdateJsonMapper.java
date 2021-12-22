package com.ncu.chygienicjavaweb.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

public interface UpdateJsonMapper {

    @Update("update user_json set  json_content=#{json_content} where id=#{json_id}")
    @Results({@Result(property = "json_id",column = "id")})
    void UpdateUser_json(String json_content,Integer json_id);
}
