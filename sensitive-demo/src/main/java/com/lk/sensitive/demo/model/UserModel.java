package com.lk.sensitive.demo.model;

import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveType;
import lombok.Data;

@Data
@SensitiveModel(SensitiveMode.MYBATIS)
public class UserModel {

    private static final int vid=33;

    private Integer id;
    /**
     * 用户名
     */
    @SensitiveField(value = SensitiveType.CHINESE_NAME)
    private String userName;

    /**
     * 身份证号
     */
    @SensitiveField(value = SensitiveType.ID_CARD)
    private String idcard;


    private int age;
    @SensitiveField(value = SensitiveType.EMAIL)
    private String email;
}
