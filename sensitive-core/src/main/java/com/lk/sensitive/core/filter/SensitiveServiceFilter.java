package com.lk.sensitive.core.filter;

import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveTypeHandler;
import com.lk.sensitive.core.type.SensitiveTypeRegisty;
import com.lk.sensitive.core.type.SensitivieFieldType;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Objects;

/**
 * service 数据脱敏过滤器
 *
 * @author liangwei
 */
public class SensitiveServiceFilter {


    public static Object process(Object object) {
        if (Objects.isNull(object)) {
            return null;
        }
        Class c = object.getClass();

        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            for (Object o1 : collection) {
                SensitiveServiceFilter.processSelector(o1, o1.getClass());
            }
        } else {
            SensitiveServiceFilter.processSelector(object, c);

        }
        return object;


    }

    private static void processSelector(Object bean, Class objectClass) {


        if (objectClass.isAnnotationPresent(SensitiveModel.class)) {
            SensitiveModel sensitiveModel = (SensitiveModel) objectClass.getAnnotation(SensitiveModel.class);


            if (sensitiveModel.value() == SensitiveMode.AOPSERVIE) {
                try {
                    processBean(bean, objectClass);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (sensitiveModel.value() == SensitiveMode.MYBATIS) {
                try {
                    processBean(bean, objectClass);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void processBean(Object bean, Class bclass) throws IllegalAccessException {
        for (Field field : bclass.getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldObject = field.get(bean);
            if (Objects.isNull(fieldObject)) {
                continue;
            }
            if (field.isAnnotationPresent(SensitiveField.class)) {
                SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
                if (sensitiveField.type() == SensitivieFieldType.STRING&&fieldObject instanceof java.lang.String) {
                    SensitiveTypeHandler sensitiveTypeHandler = SensitiveTypeRegisty.get(sensitiveField.value());
                    if (sensitiveTypeHandler != null) {
                        String result = sensitiveTypeHandler.handle(fieldObject);
                        field.set(bean, result);
                    }
                } else if (sensitiveField.type() == SensitivieFieldType.ENTITY) {
                    process(fieldObject);
                }
            }


        }


    }


}
