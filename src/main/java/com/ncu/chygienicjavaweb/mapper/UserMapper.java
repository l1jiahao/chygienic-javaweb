package com.ncu.chygienicjavaweb.mapper;


import com.ncu.chygienicjavaweb.entity.User;
import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @author nogra
 */

public interface UserMapper {

    @Select("select u.user_name,u.sex,s.school_name,c.career_name,u.identity_number,u.phone_number   " +
            "from user u,career c,school s where u.career_id=c.id and u.school_id=s.id")
    @Results({
            @Result(property = "name", column = "user_name"),
            @Result(property = "school", column = "school_name"),
            @Result(property = "career", column = "career_name"),
            @Result(property = "identity", column = "identity_number"),
            @Result(property = "phone", column = "phone_number")
    })
    /**
     * 获取用户的信息
     */
    ArrayList<User> getAll();

    @Select("select u.user_name,u.sex,s.school_name,c.career_name,u.identity_number,u.phone_number   " +
            "from user u,career c,school s where u.career_id=c.id and u.school_id=s.id and u.id=#{id}")
    @Results({
            @Result(property = "name", column = "user_name"),
            @Result(property = "school", column = "school_name"),
            @Result(property = "career", column = "career_name"),
            @Result(property = "identity", column = "identity_number"),
            @Result(property = "phone", column = "phone_number")
    })
    User getOne(int id);
}
