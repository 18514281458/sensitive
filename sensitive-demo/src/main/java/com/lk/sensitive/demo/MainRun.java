package com.lk.sensitive.demo;


import com.lk.sensitive.aop.enums.EnableSensitiveService;
import com.lk.sensitive.mybatis.enums.EnableSensitiveMybatis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableSensitiveService
@EnableSensitiveMybatis
@MapperScan("com.lk.sensitive.demo.mapper")
public class MainRun {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MainRun.class)

                .run(args);
    }
}
