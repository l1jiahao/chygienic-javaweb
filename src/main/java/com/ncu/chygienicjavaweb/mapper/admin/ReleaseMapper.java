package com.ncu.chygienicjavaweb.mapper.admin;

import org.apache.ibatis.annotations.Insert;



public interface ReleaseMapper {
    @Insert("INSERT INTO limit_column(limit_columns) VALUES(#{limit_columns})")
    void insert(String limit_columns);
}
