package com.ncu.chygienicjavaweb.entity.admin;

import java.sql.Timestamp;

//第6个接口实体，获取已经发布的表单
public class GetForm {
    private int proj_batch_id;
    private String proj_batch_name;
    private int limit_id;
    private String limit_columns;
    private Timestamp establish_time;
    private Timestamp establish_end_time;

    public int getProj_batch_id() {
        return proj_batch_id;
    }

    public void setProj_batch_id(int proj_batch_id) {
        this.proj_batch_id = proj_batch_id;
    }

    public String getProj_batch_name() {
        return proj_batch_name;
    }

    public void setProj_batch_name(String proj_batch_name) {
        this.proj_batch_name = proj_batch_name;
    }

    public int getLimit_id() {
        return limit_id;
    }

    public void setLimit_id(int limit_id) {
        this.limit_id = limit_id;
    }

    public String getLimit_columns() {
        return limit_columns;
    }

    public void setLimit_columns(String limit_columns) {
        this.limit_columns = limit_columns;
    }

    public Timestamp getEstablish_time() {
        return establish_time;
    }

    public void setEstablish_time(Timestamp establish_time) {
        this.establish_time = establish_time;
    }

    public Timestamp getEstablish_end_time() {
        return establish_end_time;
    }

    public void setEstablish_end_time(Timestamp establish_end_time) {
        this.establish_end_time = establish_end_time;
    }
}
