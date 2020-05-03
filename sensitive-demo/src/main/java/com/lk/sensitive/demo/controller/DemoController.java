package com.lk.sensitive.demo.controller;

import com.lk.sensitive.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("get")
    public Object get() {
        return demoService.get();
    }

    @GetMapping("list")
    public Object list() {
        return demoService.list();
    }
}
