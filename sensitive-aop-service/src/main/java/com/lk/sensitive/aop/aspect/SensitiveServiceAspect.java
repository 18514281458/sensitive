package com.lk.sensitive.aop.aspect;

import com.lk.sensitive.core.filter.SensitiveServiceFilter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Collection;

/**
 * Service aspect
 *
 * @author liangwei
 */

public class SensitiveServiceAspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object c = methodInvocation.proceed();
        if (c instanceof Collection) {
            Collection collection = (Collection) c;
            for (Object o1 : collection) {
                SensitiveServiceFilter.process(o1);
            }
            return collection;
        } else {
            SensitiveServiceFilter.process(c);
            return c;

        }

    }


}
