package com.lk.sensitive.demo;


import com.lk.sensitive.aop.enums.EnableSensitiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSensitiveService
public class MainRun {

    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
    }
}
