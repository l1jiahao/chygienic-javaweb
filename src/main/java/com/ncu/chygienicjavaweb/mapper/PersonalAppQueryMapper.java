package com.ncu.chygienicjavaweb.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.ncu.chygienicjavaweb.entity.PersonalAppQuery;

import java.util.ArrayList;

public interface PersonalAppQueryMapper {

    @Select("select p.project_name,p.project_status from project p,user_project up\n" +
            "where p.id=up.project_id and p.project_status=0 ")
    @Results({
            @Result(property = "name", column = "project_name"),
            @Result(property = "status", column = "project_status")
    })
    /**
     * 获取个人项目申报待审核的全部项目
     */
    ArrayList<PersonalAppQuery> getWaitAll();


    @Select("select p.project_name,p.project_status from project p,user_project up\n" +
            "where p.id=up.project_id and p.project_status=0 and up.user_id=#{id}")
    @Results({
            @Result(property = "name", column = "project_name"),
            @Result(property = "status", column = "project_status")
    })
    PersonalAppQuery getWaitOne(int id);



    @Select("select p.project_name,p.project_status from project p where p.project_status=1")
    @Results({
            @Result(property = "name", column = "project_name"),
            @Result(property = "status", column = "project_status")
    })
    /**
     * 获取个人项目申报已通过的全部项目
     */
    ArrayList<PersonalAppQuery> getPassAll();


    @Select("select p.project_name,p.project_status from project p,user_project up\n" +
            "where p.id=up.project_id and p.project_status=1 and up.user_id=#{id}")
    @Results({
            @Result(property = "name", column = "project_name"),
            @Result(property = "status", column = "project_status")
    })
    PersonalAppQuery getPassOne(int id);


}
