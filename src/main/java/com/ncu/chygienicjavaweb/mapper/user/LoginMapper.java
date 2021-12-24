package com.ncu.chygienicjavaweb.mapper.user;

import com.ncu.chygienicjavaweb.entity.UserInformation;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {


    //返回用户信息
    @Select("select user.id,role_id,user_name,sex,school_name,career_name,identity_number, phone_number\n" +
            "from user,school,career where\n" +
            "        school_name in (select school_name from school where school.id in\n" +
            "                    (select school_id from user where user_account=#{account}))\n" +
            "  and\n" +
            "        career_name in (select career_name from career where career.id in (\n" +
            "        select career_id from user where user_account=#{account}))\n" +
            "  and user_account=#{account} and user_password=#{password}")
    @Results({
            @Result(property = "user_id",column = "id"),
            @Result(property="name",column = "user_name"),
            @Result(property="school",column = "school_name"),
            @Result(property = "career",column = "career_name"),
            @Result(property = "account",column = "user_account"),
            @Result(property = "password",column = "user_password")
    })
    UserInformation GetUserInformation(String account,String password);

}
