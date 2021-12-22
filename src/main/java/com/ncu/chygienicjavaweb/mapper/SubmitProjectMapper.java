package com.ncu.chygienicjavaweb.mapper;


import com.ncu.chygienicjavaweb.entity.submitproject.Project;
import com.ncu.chygienicjavaweb.entity.submitproject.UserJson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;



public interface SubmitProjectMapper {

    //将json数据存入到user_json表中，同时获取到该项对应的id（暂时未实现）
    @Insert("insert into user_json (json_content)  values(#{json_content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void SubmitTechProject(UserJson userJson);


    //存project表
    @Insert("insert into project (project_name,project_type_id,json_id,limit_id,appendix,project_status)\n" +
            "values(#{project_name},#{project_type_id},#{json_id},#{limit_id},#{appendix},0)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void SubmitProject(Project project);


    //存user_project表
    @Insert("insert into user_project (user_id,project_id)\n" +
            "values(#{user_id},#{project_id})")
    void SubmitUserProject(Integer user_id,Integer project_id);
}
