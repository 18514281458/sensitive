package com.lk.sensitive.aop.enums;


import com.lk.sensitive.aop.config.InterceptorAnnotationConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(InterceptorAnnotationConfig.class)
public @interface EnableSensitive {
}
