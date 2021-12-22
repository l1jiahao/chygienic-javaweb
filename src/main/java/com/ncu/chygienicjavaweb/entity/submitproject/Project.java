package com.ncu.chygienicjavaweb.entity.submitproject;

public class Project {
        private int id;
        private String project_name;
        private Integer project_type_id;
        private Integer json_id;
        private Integer limit_id;
        private Integer project_status;
        private String appendix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Integer getProject_type_id() {
        return project_type_id;
    }

    public void setProject_type_id(Integer project_type_id) {
        this.project_type_id = project_type_id;
    }

    public Integer getJson_id() {
        return json_id;
    }

    public void setJson_id(Integer json_id) {
        this.json_id = json_id;
    }

    public Integer getLimit_id() {
        return limit_id;
    }

    public void setLimit_id(Integer limit_id) {
        this.limit_id = limit_id;
    }

    public Integer getProject_status() {
        return project_status;
    }

    public void setProject_status(Integer project_status) {
        this.project_status = project_status;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }
}
