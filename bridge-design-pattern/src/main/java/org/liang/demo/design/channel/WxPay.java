package org.liang.demo.design.channel;

import cn.hutool.log.StaticLog;
import org.liang.demo.design.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author liang
 * Date 2020/11/28-19:53
 */
public class WxPay extends Pay{

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {

        StaticLog.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);

        boolean security = payMode.security(uId);

        if (!security) {
            StaticLog.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        StaticLog.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
