package com.lk.sensitive.demo;


import com.lk.sensitive.aop.enums.EnableSensitiveService;
import com.lk.sensitive.mybatis.enums.EnableSensitiveMybatis;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lk.sensitive.demo.*")
@SpringBootApplication
@EnableSensitiveService
@EnableSensitiveMybatis
public class MainRun {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MainRun.class)

                .run(args);
    }
}
