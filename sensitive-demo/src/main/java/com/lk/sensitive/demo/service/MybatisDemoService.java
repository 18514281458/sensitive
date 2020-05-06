package com.lk.sensitive.demo.service;

import com.lk.sensitive.demo.model.UserModel;

import java.util.List;

public interface MybatisDemoService {

    int add(UserModel userModel);

    List<UserModel> list();

    UserModel get(int id);

}
