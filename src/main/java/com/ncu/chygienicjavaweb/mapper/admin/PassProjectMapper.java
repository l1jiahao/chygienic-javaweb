package com.ncu.chygienicjavaweb.mapper.admin;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

//第12个接口mapper层，审核项目
public interface PassProjectMapper {

    //审核通过某些项目
    @Update("update project set project_status=1 where project.id=#{proj_id}")
    @Results({
        @Result(property = "proj_id",column = "id")
    })
    void passOneProject(int proj_id);


    //审核不通过某些项目
    @Update("update project set project_status=2 where project.id=#{proj_id}")
    @Results({
            @Result(property = "proj_id",column = "id")
    })
    void notpassOneProject(int proj_id);
}
