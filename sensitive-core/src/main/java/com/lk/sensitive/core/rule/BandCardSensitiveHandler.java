package com.lk.sensitive.core.rule;

import com.lk.sensitive.core.type.SensitiveType;
import com.lk.sensitive.core.type.SensitiveTypeHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 银行卡号脱敏
 * 只留前四位和后四位
 * 6227 0383 3938 3938 393 脱敏结果: 6227 **** **** ***8 393
 */
public class BandCardSensitiveHandler implements SensitiveTypeHandler {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.BANK_CARD;
    }

    @Override
    public String handle(Object src) {
        if(src==null){
            return null;
        }
        String bankCard = src.toString();
        return StringUtils.left(bankCard, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(bankCard, 4), StringUtils.length(bankCard), "*"), "***"));

    }
}
