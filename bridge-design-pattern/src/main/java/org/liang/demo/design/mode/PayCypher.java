package org.liang.demo.design.mode;

import cn.hutool.log.StaticLog;

/**
 * @author liang
 * Date 2020/11/28-20:00
 * 密码支付
 */
public class PayCypher implements IPayMode{
    @Override
    public boolean security(String uId) {
        StaticLog.info("密码支付，风控校验环境安全");
        return true;
    }
}
