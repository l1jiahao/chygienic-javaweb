package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.User;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nogra
 */
public interface UserMapper {

    @Select("SELECT * FROM test")
    @Results()
    List<User> getAll();
}
