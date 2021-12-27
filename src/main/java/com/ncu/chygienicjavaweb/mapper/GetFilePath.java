package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.UpFile;
import org.apache.ibatis.annotations.Select;

public interface GetFilePath {
    @Select("select project_id,appendix_content from project_appendix where project_id=#{project_id}")
    UpFile getFilePathAndName(int project_id);

}
