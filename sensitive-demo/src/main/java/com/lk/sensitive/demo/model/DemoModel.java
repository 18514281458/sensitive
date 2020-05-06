package com.lk.sensitive.demo.model;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitivieFieldType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@SensitiveModel(value = SensitiveMode.AOPSERVIE)
public class DemoModel implements Serializable {
    public DemoModel() {
        this.name = "梁伟";
        this.photo = "18514281458";
        this.address = "北京市朝阳区摩托罗拉";
        this.none = "帅哥";
        Demo2Model demoModel2=new Demo2Model();
        demoModel2.setAddress("北京市朝阳区摩托罗拉asdasdasdas");
        demoModel2.setName("梁伟2233");
        demoModel2.setPhoto("18514281458");
        demoModel2.setName("帅哥");
        this.demo2Model=demoModel2;
        List<Demo2Model> demoModels= Lists.newArrayList();

        Demo2Model demoModel3=new Demo2Model();
        demoModel3.setAddress("北京市朝阳区摩托罗拉asdasdasdas");
        demoModel3.setName("梁伟2233");
        demoModel3.setPhoto("18514281458");
        demoModel3.setName("帅哥");
        Demo2Model demoModel4=new Demo2Model();
        demoModel4.setAddress("北京市朝阳区摩托罗拉asdasdasdas");
        demoModel4.setName("梁伟2233");
        demoModel4.setPhoto("18514281458");
        demoModel4.setName("帅哥");
        demoModels.add(demoModel3);
        demoModels.add(demoModel4);
        this.demo2ModelList=demoModels;
        Map mp= Maps.newConcurrentMap();

    }

    @SensitiveField(value = SensitiveType.CHINESE_NAME)
    private String name;
    @SensitiveField(value = SensitiveType.MOBILE_PHONE)
    private String photo;
    @SensitiveField(value = SensitiveType.ADDRESS)
    private String address;

    private String none;
    @SensitiveField(type = SensitivieFieldType.ENTITY)
    private Demo2Model demo2Model;
    @SensitiveField(type = SensitivieFieldType.ENTITY)
    private List<Demo2Model> demo2ModelList;

}
