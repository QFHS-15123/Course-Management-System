package com.example.schoolwebsite_spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.schoolwebsite_spring.dao")

@SpringBootApplication

public class SchoolwebsiteSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolwebsiteSpringApplication.class, args);
    }

}
