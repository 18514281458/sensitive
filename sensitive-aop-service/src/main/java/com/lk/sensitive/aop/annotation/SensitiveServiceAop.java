package com.lk.sensitive.aop.annotation;

import com.lk.sensitive.aop.enums.SensitiveServiceMehodEnum;

import java.lang.annotation.*;

/**
 * service 注解
 * @author liangwei
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveServiceAop {
    /**
     * 作用域
     * @return
     */
    SensitiveServiceMehodEnum scope();
}
