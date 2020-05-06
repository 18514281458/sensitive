package com.lk.sensitive.aop.enums;


import com.lk.sensitive.aop.config.SensitiveAopConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SensitiveAopConfig.class})
public @interface EnableSensitiveService {
}
