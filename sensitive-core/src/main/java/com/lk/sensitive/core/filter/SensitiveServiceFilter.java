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


    public static void process(Object object, SensitiveMode sensitiveMode) throws IllegalAccessException {


        processDataTypeFilter(object, sensitiveMode);


    }

    private static void processDataTypeFilter(Object object, SensitiveMode sensitiveMode) throws IllegalAccessException {


        if (Objects.isNull(object)) {
            return;
        }
        Class c = object.getClass();

        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            for (Object o1 : collection) {
                SensitiveServiceFilter.processSelector(o1, o1.getClass(), sensitiveMode);
            }
        } else {
            SensitiveServiceFilter.processSelector(object, c, sensitiveMode);

        }

    }

    private static void processSelector(Object bean, Class objectClass, SensitiveMode sensitiveMode) throws IllegalAccessException {


        if (objectClass.isAnnotationPresent(SensitiveModel.class)) {
            SensitiveModel sensitiveModel = (SensitiveModel) objectClass.getAnnotation(SensitiveModel.class);

            if (sensitiveModel.value() != sensitiveMode) {
                throw new RuntimeException("Entity Annotation SensitiveMode  is error[" + objectClass + "]");
            }

            if (sensitiveModel.value() == SensitiveMode.AOPSERVIE && SensitiveMode.AOPSERVIE == sensitiveMode) {

                processBean(bean, objectClass, sensitiveMode);

            } else if (sensitiveModel.value() == SensitiveMode.MYBATIS && sensitiveMode == SensitiveMode.MYBATIS) {

                processBean(bean, objectClass, sensitiveMode);

            }
        }

    }

    private static void processBean(Object bean, Class bclass, SensitiveMode sensitiveMode) throws IllegalAccessException {
        for (Field field : bclass.getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldObject = field.get(bean);
            if (Objects.isNull(fieldObject)) {
                continue;
            }
            if (field.isAnnotationPresent(SensitiveField.class)) {
                SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
                if (sensitiveField.type() == SensitivieFieldType.STRING && fieldObject instanceof java.lang.String) {
                    SensitiveTypeHandler sensitiveTypeHandler = SensitiveTypeRegisty.get(sensitiveField.value());
                    if (sensitiveTypeHandler != null) {
                        String result = sensitiveTypeHandler.handle(fieldObject);
                        field.set(bean, result);
                    }
                } else if (sensitiveField.type() == SensitivieFieldType.ENTITY) {
                    processDataTypeFilter(fieldObject, sensitiveMode);
                }
            }


        }


    }


}
