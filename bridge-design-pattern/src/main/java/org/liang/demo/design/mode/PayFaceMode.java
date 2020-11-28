package org.liang.demo.design.mode;

import cn.hutool.log.StaticLog;

/**
 * @author liang
 * Date 2020/11/28-20:01
 * 人脸支付
 */
public class PayFaceMode implements IPayMode{
    @Override
    public boolean security(String uId) {

        StaticLog.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
