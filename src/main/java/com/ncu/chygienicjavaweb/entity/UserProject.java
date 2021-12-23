package com.ncu.chygienicjavaweb.entity;

public class UserProject {
    private Integer proj_id;
    private String  proj_name;
    private Integer proj_type_id;
    private Integer status;

    public Integer getProj_id() {
        return proj_id;
    }

    public void setProj_id(Integer proj_id) {
        this.proj_id = proj_id;
    }

    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public Integer getProj_type_id() {
        return proj_type_id;
    }

    public void setProj_type_id(Integer proj_type_id) {
        this.proj_type_id = proj_type_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
