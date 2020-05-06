package com.lk.sensitive.core.type;

/**
 * 脱敏类型
 */
public enum SensitiveType {
    /**
     * 不脱
     */
    NONE,

    /**
     * 默认
     */
    DEFAUL,
    /**
     * 中文名
     */
    CHINESE_NAME,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 座机号
     */
    FIXED_PHONE,
    /**
     * 手机号
     */
    MOBILE_PHONE,
    /**
     * 地址
     */
    ADDRESS,
    /**
     * 电子邮件
     */
    EMAIL,
    /**
     * 银行卡
     */
    BANK_CARD

}
