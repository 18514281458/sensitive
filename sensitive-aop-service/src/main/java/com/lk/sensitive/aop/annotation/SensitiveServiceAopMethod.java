package com.lk.sensitive.aop.annotation;

import java.lang.annotation.*;

/**
 *
 * #SensitiveServiceAop 作用方法上
 * @author liangwei
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveServiceAopMethod {
}
