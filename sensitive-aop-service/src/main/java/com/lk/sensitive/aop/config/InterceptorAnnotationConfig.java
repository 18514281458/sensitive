package com.lk.sensitive.aop.config;

import com.lk.sensitive.aop.annotation.SensitiveServiceAop;
import com.lk.sensitive.aop.annotation.SensitiveServiceAopMethod;
import com.lk.sensitive.aop.aspect.SensitiveServiceAspect;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorAnnotationConfig {
 
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor3() {

        SensitiveServiceAspect interceptor = new SensitiveServiceAspect();
 
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(SensitiveServiceAop.class, SensitiveServiceAopMethod.class, false);

 
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }
}
