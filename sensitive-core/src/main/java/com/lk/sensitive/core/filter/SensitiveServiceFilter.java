package com.lk.sensitive.core.filter;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.lk.sensitive.core.annotation.SensitiveField;
import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitiveTypeHandler;
import com.lk.sensitive.core.type.SensitiveTypeRegisty;

import java.lang.reflect.Field;

/**
 * service 数据格式化
 *
 * @author liangwei
 */
public class SensitiveServiceFilter implements ValueFilter {
    @Override
    public Object process(Object o, String name, Object value) {
        try {
            Field field = o.getClass().getDeclaredField(name);
            SensitiveField sensitiveField;
            if ((sensitiveField = field.getAnnotation(SensitiveField.class)) == null) {
                return value;
            }
            SensitiveType sensitiveType = sensitiveField.value();
            SensitiveTypeHandler sensitiveTypeHandler = SensitiveTypeRegisty.get(sensitiveType);
            return sensitiveTypeHandler.handle(value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
