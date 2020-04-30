package com.lk.sensitive.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lk.sensitive.aop.annotation.SensitiveServiceAop;
import com.lk.sensitive.aop.annotation.SensitiveServiceAopMethod;
import com.lk.sensitive.aop.enums.SensitiveServiceMehodEnum;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.filter.SensitiveServiceFilter;
import com.lk.sensitive.core.type.SensitiveMode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Service aspect
 *
 * @author liangwei
 */
@Aspect
@Component
public class SensitiveServiceAspect {
    @Pointcut("@annotation(com.lk.sensitive.aop.annotation.SensitiveServiceAop)")
    public void sensitiveServicePoint() {

    }

    @Around("sensitiveServicePoint()")
    public Object checkAfter(ProceedingJoinPoint joinPoint) {
        Object o = null;
        try {
            o = joinPoint.proceed(joinPoint.getArgs());
            boolean f = this.getSensitiveServiceAop(joinPoint);
            if (f) {

                if (o == null) {
                    return o;
                }
                if (o instanceof Map) {
                    return o;
                }
                Class<?> c = o.getClass();
                if (c.isAnnotationPresent(SensitiveModel.class)) {
                    SensitiveModel sensitiveModel = c.getAnnotation(SensitiveModel.class);
                    if (sensitiveModel.value() == SensitiveMode.AOPSERVIE) {
                        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(o, new SensitiveServiceFilter()));
                        return JSON.toJavaObject(jsonObject, c);
                    } else {
                        return o;
                    }
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }

    private boolean getSensitiveServiceAop(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Class<?> targetClass = joinPoint.getTarget().getClass();
        SensitiveServiceAop sensitiveServiceAop = targetClass.getAnnotation(SensitiveServiceAop.class);
        if (sensitiveServiceAop != null) {
            if (sensitiveServiceAop.scope() == SensitiveServiceMehodEnum.ALL) {
                return true;
            } else if (sensitiveServiceAop.scope() == SensitiveServiceMehodEnum.CUSTOM) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method targetMethod = methodSignature.getMethod();
                if (targetMethod.isAnnotationPresent(SensitiveServiceAopMethod.class)) {
                    return true;
                }
            }

        }
        return false;
    }
}
