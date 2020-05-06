package com.lk.sensitive.mybatis.config;

import com.lk.sensitive.mybatis.interceptor.ResultInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 添加拦截器
 */
@Configuration
public class SensitiveMybatisConfig {

    @Bean
    public ConfigurationCustomizer getConfigurationCustomizer() {


        ResultInterceptor resultInterceptor = new ResultInterceptor();
        return (configuration) -> configuration.addInterceptor(resultInterceptor);


    }
}
