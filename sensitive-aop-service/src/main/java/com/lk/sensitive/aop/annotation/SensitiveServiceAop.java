package com.lk.sensitive.aop.annotation;

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

}
