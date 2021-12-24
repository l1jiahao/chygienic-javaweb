package com.ncu.chygienicjavaweb.mapper.admin;

import com.ncu.chygienicjavaweb.entity.admin.GetForm;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

//第6个接口Mapper层，获取已经发布的表单
public interface GetFormMapper {
    @Select("select p.id,project_batch_name,limit_id,limit_columns,establish_end_time,establish_end_time\n" +
            "from project_batch p,limit_column l where p.limit_id = l.id and p.project_type_id =#{proj_type_id}")
    @Results({
            @Result(property = "proj_batch_id",column = "id"),
            @Result(property = "proj_batch_name",column = "project_batch_name"),
            @Result(property = "limit_id",column = "limit_id"),
            @Result(property = "limit_columns",column = "limit_columns"),
            @Result(property = "establish_time",column = "establish_time"),
            @Result(property = "establish_end_time",column = "establish_end_time")
    })
    ArrayList<GetForm> getAllForm(int proj_type_id);
}
