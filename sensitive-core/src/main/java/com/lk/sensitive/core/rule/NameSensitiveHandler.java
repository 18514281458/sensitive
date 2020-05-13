package com.lk.sensitive.core.rule;

import com.google.common.base.Strings;
import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitiveTypeHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 姓名脱敏的解析类
 * 中文姓名只显示第一个汉字，其他隐藏为2个星号
 */
public class NameSensitiveHandler implements SensitiveTypeHandler {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.CHINESE_NAME;
    }

    @Override
    public String handle(Object src) {
        if (src==null) {
            return "";
        }
        String fullName = src.toString();
        String name = StringUtils.left(fullName, 1);
        return Strings.padEnd(name, StringUtils.length(fullName), '*');
    }


}
