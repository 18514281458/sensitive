package com.lk.sensitive.core.type;

public interface SensitiveTypeHandler {

    /**
     * 获取脱敏的类型枚举
     * @return ;
     */
    SensitiveType getSensitiveType();
    /**
     * 对数据的值进行脱敏处理
     * @return 脱敏后的数据
     */
    String handle(Object src);
}
