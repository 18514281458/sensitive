package com.lk.sensitive.core.rule;

import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitiveTypeHandler;

/**
 * 不脱敏
 * @author chenhaiyang
 */
public class NoneSensitiveHandler implements SensitiveTypeHandler {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.NONE;
    }

    @Override
    public String handle(Object src) {
        if(src!=null){
            return src.toString();
        }
        return null;
    }
}
