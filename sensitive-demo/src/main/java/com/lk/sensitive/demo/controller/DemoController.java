package com.lk.sensitive.demo.controller;

import com.lk.sensitive.demo.model.UserModel;
import com.lk.sensitive.demo.service.DemoService;
import com.lk.sensitive.demo.service.MybatisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private MybatisDemoService mybatisDemoService;

    @GetMapping("get")
    public Object get() {
        return demoService.get();
    }

    @GetMapping("list")
    public Object list() {
        return demoService.list();
    }


    @GetMapping("/mybatis/get/{id}")
    public Object mget(@PathVariable("id") Integer id) {
        return mybatisDemoService.get(id);
    }

    @GetMapping("/mybatis/list")
    public Object mlist() {
        return mybatisDemoService.list();
    }

    @GetMapping("/mybatis/add")
    public Object madd() {
        UserModel userDTO=new UserModel();
        userDTO.setAge(11);
        userDTO.setEmail("565472901@qq.com");
        userDTO.setIdcard("140221199405293011");
        userDTO.setUserName("梁伟");
        return mybatisDemoService.add(userDTO);
    }

}
