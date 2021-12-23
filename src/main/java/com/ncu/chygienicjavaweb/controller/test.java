package com.ncu.chygienicjavaweb.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String...args){
        //要把establish_time等获取到，（转换为String类型），再把这个转换回LocalDataTime类型
        String start="2021-12-14 16:46:01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start1= LocalDateTime.parse(start, formatter);
        System.out.println(start1);

    }

}
