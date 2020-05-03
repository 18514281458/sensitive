package com.lk.sensitive.demo.service;

import com.lk.sensitive.demo.model.DemoModel;

import java.util.List;

public interface DemoService {

    List<DemoModel> list();

    DemoModel get();
}
