package com.lk.sensitive.core.type;

/**
 * 脱敏方式
 */
public enum SensitiveMode {
    /**
     * MYBATIS
     */
    MYBATIS,
    /**
     * service
     */
    AOPSERVIE,

    /**
     * view response 拦截器
     */
    RESPONSE,

    /**
     * view fastjson转换器
     */
    FASTJSON
}
