package com.lk.sensitive.demo.model;

import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitivieFieldType;
import lombok.Data;

import java.util.List;

@Data
@SensitiveModel(value = SensitiveMode.AOPSERVIE)
public class Demo2Model {

    @SensitiveField(value = SensitiveType.CHINESE_NAME)
    private String name;
    @SensitiveField(value = SensitiveType.MOBILE_PHONE)
    private String photo;
    @SensitiveField(value = SensitiveType.ADDRESS)
    private String address;

    private String none;
    @SensitiveField(type= SensitivieFieldType.ENTITY)
    private Demo2Model demo2Model;
    @SensitiveField(type= SensitivieFieldType.ENTITY)
    private List<Demo2Model> demo2ModelList;
}
