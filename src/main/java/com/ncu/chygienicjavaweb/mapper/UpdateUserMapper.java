package com.ncu.chygienicjavaweb.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

public interface UpdateUserMapper {
    //修改电话号码
    @Update("update user set  phone_number=#{phone_number} where id=#{user_id}")
    @Results({@Result(property = "user_id", column = "id")})
    void UpdatePhoneNumber(String phone_number,int user_id);

    //修改密码
    @Update("update user set  user_password=#{user_password} where id=#{user_id}")
    @Results({@Result(property = "user_id", column = "id")})
    void UpdateUserPassword(String user_password,int user_id);
}
