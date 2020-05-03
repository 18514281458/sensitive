package com.lk.sensitive.demo;


import com.lk.sensitive.aop.enums.EnableSensitive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSensitive
public class MainRun {

    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
    }
}
