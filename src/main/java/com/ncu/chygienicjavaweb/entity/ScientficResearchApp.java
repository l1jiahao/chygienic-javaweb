package com.ncu.chygienicjavaweb.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ScientficResearchApp {
    private String name;//项目名称
    private int id;//立项编号
    private int type_id;//项目性质
    private Timestamp establish_time;//立项时间
    private Timestamp establish_end_time;//验收时间
    private int fee;//项目经费

}
