package com.ncu.chygienicjavaweb.mapper.admin;

import com.ncu.chygienicjavaweb.entity.admin.GetFinishedProject;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//第11个接口Mapper层，获取某个表单中用户已填项目
public interface GetFinishedProjectMapper {
    @Select("select p.id,project_status,json_content from project p,user_json u where p.json_id = u.id and limit_id = #{limit_id}")
    @Results({
            @Result(property = "proj_id",column = "id"),
            @Result(property = "status",column = "project_status"),
            @Result(property = "json_content",column = "json_content")
    })
    ArrayList<GetFinishedProject> getAllFinishedProject(int limit_id);
}
