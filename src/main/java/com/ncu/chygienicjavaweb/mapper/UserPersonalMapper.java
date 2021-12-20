package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.UserInformation;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserPersonalMapper {
    @Select("select user_name,sex,user_account,identity_number,\n" +
            "       phone_number,school_name,career_name\n" +
            "from user,school,career\n" +
            "where\n" +
            "      school_name in (select school_name from school\n" +
            "                      where id in \n" +
            "                            (select school_id from user where user_account=#{account}))\n" +
            "  and\n" +
            "      career_name in (select career_name from career where id in (\n" +
            "    select career_id from user where user_account=#{account}\n" +
            "))\n" +
            "  and user_account=#{account}")
    @Results({
            @Result(property="name",column = "user_name"),
            @Result(property="school",column = "school_name"),
            @Result(property = "career",column = "career_name"),
            @Result(property = "identity",column = "identity_number"),
            @Result(property = "phone",column = "phone_number"),
            @Result(property = "account",column = "user_account"),
    })
    UserInformation GetUserInformation(String account);

}
