package com.ncu.chygienicjavaweb.mapper.user;

import com.ncu.chygienicjavaweb.entity.LimitColumn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.time.LocalDateTime;

public interface PublishMapper {
    //对应第十个接口，先存limit_column表，再存project_batch表

    //先存进limit_column，获取到相应的自增id
    @Insert("insert into limit_column (limit_columns) values (#{limit_columns})")
    @Results({@Result(property = "limit_id",column = "id")})
    @Options(useGeneratedKeys = true, keyProperty = "limit_id")
    void InsertLimitColumn(LimitColumn limitColumn);


    //获取到limit_column相应的id后再存project_batch表
    @Insert("insert into project_batch (project_batch_name, limit_id, project_type_id, " +
            "establish_start_time, establish_end_time)\n" +
            "values (#{proj_batch_name},#{limit_id},#{proj_type_id}," +
            "#{establish_time},#{establish_end_time})")
    void InsertProjectBatch(Integer limit_id,String proj_batch_name,Integer proj_type_id,LocalDateTime establish_time,LocalDateTime establish_end_time);



}
