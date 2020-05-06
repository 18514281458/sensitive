package com.lk.sensitive.core.annotation;


import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitivieFieldType;

import java.lang.annotation.*;

/**
 * 标注在字段上，用以说明字段上那些类型需要脱敏
 * @author liangwei
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveField {
    /**
     * 脱敏类型
     * 不同的脱敏类型置换*的方式不同
     * @return SensitiveType
     */
    SensitiveType value() default SensitiveType.NONE;

    SensitivieFieldType type()default SensitivieFieldType.STRING;
}
