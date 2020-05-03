package com.lk.sensitive.demo.model;


import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveType;
import lombok.Data;

import java.io.Serializable;

@Data
@SensitiveModel(value = SensitiveMode.AOPSERVIE)
public class DemoModel implements Serializable {
    public DemoModel() {
        this.name = "梁伟";
        this.photo = "18514281458";
        this.address = "北京市朝阳区摩托罗拉";
        this.none = "帅哥";
    }

    @SensitiveField(value = SensitiveType.CHINESE_NAME)
    private String name;
    @SensitiveField(value = SensitiveType.MOBILE_PHONE)
    private String photo;
    @SensitiveField(value = SensitiveType.ADDRESS)
    private String address;

    private String none;
}
