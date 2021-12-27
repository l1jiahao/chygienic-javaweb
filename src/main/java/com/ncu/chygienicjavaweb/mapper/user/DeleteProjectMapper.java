package com.ncu.chygienicjavaweb.mapper.user;

import org.apache.ibatis.annotations.Delete;

public interface DeleteProjectMapper {
    //先通过proj_id获取到json_id，随后可以删除json表相应的记录，再删user_project表，最后再删project表

    //删除json表相应记录
    @Delete("delete from user_json where user_json.id=(select json_id from project where project.id=#{project_id})")
    int DeleteUser_json(Integer project_id);

    //删除user_project相应记录
    @Delete("delete from user_project where project_id=#{project_id}")
    int  DeleteUser_project(Integer project_id);

    //最后删除project表
    @Delete("delete from project where id=#{project_id}")
    int DeleteProjectColumn(Integer project_id);

    //还要删一个附件表
    @Delete("delete from project_appendix where project_id=#{project_id}")
    int DeleteProjectAppendix(Integer project_id);
}
