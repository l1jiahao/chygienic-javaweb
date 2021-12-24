package com.ncu.chygienicjavaweb.mapper.admin;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

//第13个接口mapper层，修改某个项目的状态
public interface UpdateStatusMapper {
    @Update("update project set project_status = #{status} where project.id = #{proj_id}")
    @Results({
            @Result(property = "status",column = "project_status"),
            @Result(property = "proj_id",column = "id")
    })
    void updateOneStatus(int proj_id,int status);
}
