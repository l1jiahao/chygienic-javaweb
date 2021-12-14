package com.ncu.chygienicjavaweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ncu.chygienicjavaweb")
public class ChygienicJavawebApplication {

    public static void main(String[] args) {


        SpringApplication.run(ChygienicJavawebApplication.class, args);
    }

}
