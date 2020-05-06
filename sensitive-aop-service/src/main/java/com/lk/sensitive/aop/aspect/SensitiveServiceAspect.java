package com.lk.sensitive.aop.aspect;

import com.lk.sensitive.core.filter.SensitiveServiceFilter;
import com.lk.sensitive.core.type.SensitiveMode;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Service aspect
 *
 * @author liangwei
 */

public class SensitiveServiceAspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object c = methodInvocation.proceed();

        SensitiveServiceFilter.process(c, SensitiveMode.AOPSERVIE);
        return c;


    }


}
