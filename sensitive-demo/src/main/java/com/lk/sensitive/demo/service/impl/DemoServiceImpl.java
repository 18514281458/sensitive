package com.lk.sensitive.demo.service.impl;

import com.google.common.collect.Lists;
import com.lk.sensitive.aop.annotation.SensitiveServiceAop;
import com.lk.sensitive.aop.annotation.SensitiveServiceAopMethod;
import com.lk.sensitive.demo.model.DemoModel;
import com.lk.sensitive.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SensitiveServiceAop
public class DemoServiceImpl implements DemoService {

    @Override
    @SensitiveServiceAopMethod
    public List<DemoModel> list() {

        List<DemoModel> demoModels= Lists.newArrayList();
        for (int i = 0; i <5 ; i++) {
            DemoModel demoModel=new DemoModel();
            demoModels.add(demoModel);
        }
        return demoModels;
    }

    @Override
    @SensitiveServiceAopMethod
    public DemoModel get() {
        DemoModel demoModel=new DemoModel();

        return demoModel;
    }
}
