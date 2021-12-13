package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.Student;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nogra
 */
public interface StudentMapper {

    @Select("SELECT * FROM test")
    @Results()
    ArrayList<Student> getAll();
}
