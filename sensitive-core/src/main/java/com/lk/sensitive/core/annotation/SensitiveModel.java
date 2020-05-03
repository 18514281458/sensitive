package com.lk.sensitive.core.annotation;

import com.lk.sensitive.core.type.SensitiveMode;

import java.lang.annotation.*;

/**
 * 需要脱敏的model
 * @author liangwei
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveModel {
    SensitiveMode value();
}
