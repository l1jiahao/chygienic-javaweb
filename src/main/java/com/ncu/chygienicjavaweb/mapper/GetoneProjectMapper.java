package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.submitproject.UserJson;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

//获取某个项目的详情，传入一个project_id
public interface GetoneProjectMapper {
    @Select("select id,json_content from user_json where id=(select json_id from project where project.id=#{project_id})")
    @Results({@Result(property = "json_id",column = "id")})
    UserJson GetOneProject(Integer project_id);
}
