package com.lk.sensitive.demo.service.impl;

import com.lk.sensitive.demo.mapper.UserMapper;
import com.lk.sensitive.demo.model.UserModel;
import com.lk.sensitive.demo.service.MybatisDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MybatisDemoServiceImpl implements MybatisDemoService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int add(UserModel userModel) {
        return userMapper.insert(userModel);

    }

    @Override
    public List<UserModel> list() {
        return userMapper.findAll();
    }

    @Override
    public UserModel get(int id) {

        return userMapper.findOne(id);
    }
}
