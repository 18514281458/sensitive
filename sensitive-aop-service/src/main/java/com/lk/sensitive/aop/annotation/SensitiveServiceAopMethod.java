package com.lk.sensitive.aop.annotation;

import java.lang.annotation.*;

/**
 *
 * #SensitiveServiceAop
 * custome 下 用于方法上 注解
 * all 忽略这个注解
 * @author liangwei
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveServiceAopMethod {
}
