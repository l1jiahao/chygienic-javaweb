package com.ncu.chygienicjavaweb.mapper;

import com.ncu.chygienicjavaweb.entity.FileName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UploadFileMapper {
    @Insert("insert into project_appendix(project_id, appendix_content) values (#{project_id},#{appendix_content})")
    void insertFile(int project_id,String appendix_content);

    @Select("select appendix_content from project_appendix where project_id=#{project_id}")
    FileName selectFile(int project_id);
}
