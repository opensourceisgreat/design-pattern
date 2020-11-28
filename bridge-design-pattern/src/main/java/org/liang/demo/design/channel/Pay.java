package org.liang.demo.design.channel;

import org.liang.demo.design.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author liang
 * Date 2020/11/28-19:46
 */
public abstract class Pay {

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
