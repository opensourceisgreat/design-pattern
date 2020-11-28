package org.liang.demo.design.test;

import org.junit.Test;
import org.liang.demo.design.channel.Pay;
import org.liang.demo.design.channel.WxPay;
import org.liang.demo.design.channel.ZfbPay;
import org.liang.demo.design.mode.PayFaceMode;
import org.liang.demo.design.mode.PayFingerprintMode;

import java.math.BigDecimal;

/**
 * @author liang
 * Date 2020/11/28-20:02
 */
public class ApiTest {
    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));


    }
}
