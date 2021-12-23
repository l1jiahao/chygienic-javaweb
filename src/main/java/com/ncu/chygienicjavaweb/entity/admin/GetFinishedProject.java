package com.ncu.chygienicjavaweb.entity.admin;

//第11个接口实体，获取某个表单中用户已填项目
public class GetFinishedProject {
    private int proj_id;
    private int status;
    private String json_content;

    public int getProj_id() {
        return proj_id;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getJson_content() {
        return json_content;
    }

    public void setJson_content(String json_content) {
        this.json_content = json_content;
    }
}
