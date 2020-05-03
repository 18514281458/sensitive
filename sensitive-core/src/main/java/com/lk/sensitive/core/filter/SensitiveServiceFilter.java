package com.lk.sensitive.core.filter;

import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.annotation.SensitiveModel;
import com.lk.sensitive.core.type.SensitiveMode;
import com.lk.sensitive.core.type.SensitiveTypeHandler;
import com.lk.sensitive.core.type.SensitiveTypeRegisty;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * service 数据序列化
 *
 * @author liangwei
 */
public class SensitiveServiceFilter {


    public static void process(Object bean) throws IllegalAccessException {
        Class c = bean.getClass();
        if (c.isAnnotationPresent(SensitiveModel.class)) {
            SensitiveModel sensitiveModel = (SensitiveModel) c.getAnnotation(SensitiveModel.class);

            if (sensitiveModel.value() == SensitiveMode.AOPSERVIE) {
                processBean(bean, c);
            }
        }


    }

    private static void processBean(Object bean, Class bclass) throws IllegalAccessException {
        for (Field field : bclass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(bean) instanceof java.lang.String) {

                SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
                if (sensitiveField != null) {
                    SensitiveTypeHandler sensitiveTypeHandler = SensitiveTypeRegisty.get(sensitiveField.value());
                    if (sensitiveTypeHandler != null) {
                        String result = sensitiveTypeHandler.handle(field.get(bean));
                        field.set(bean, result);
                    }

                }
            }


        }
    }


}
