package org.liang.demo.design.mode;

import cn.hutool.log.StaticLog;

/**
 * @author liang
 * Date 2020/11/28-20:01
 * 指纹支付
 */
public class PayFingerprintMode implements IPayMode{
    @Override
    public boolean security(String uId) {

        StaticLog.info("指纹支付，风控校验脸部识别");
        return true;
    }
}
