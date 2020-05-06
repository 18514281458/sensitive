package com.lk.sensitive.mybatis.enums;

import com.lk.sensitive.mybatis.config.SensitiveMybatisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SensitiveMybatisConfig.class})
public @interface EnableSensitiveMybatis {
}
