package com.ncu.chygienicjavaweb.mapper.user;

import com.ncu.chygienicjavaweb.entity.UserProject;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface GetUserProjectMapper {
    //获取用户所有已经填报的项目信息，返回一个结果集
    @Select("select id,project_name,project_type_id,project_status from project where id in (select project_id from user_project where user_id=#{user_id})")
    @Results({@Result(property = "proj_id",column = "id"),
            @Result(property = "proj_name",column = "project_name"),
            @Result(property = "proj_type_id",column = "project_type_id"),
            @Result(property = "status",column = "project_status")})
    ArrayList<UserProject> GetUserAllProject(Integer user_id);
}
