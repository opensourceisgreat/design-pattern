package org.liang.demo.design.test;

import org.junit.Test;
import org.liang.demo.design.LoginSsoDecorator;
import org.liang.demo.design.SsoInterceptor;

/**
 * @author liang
 * Date 2020/11/30-19:13
 */
public class ApiTest {
    @Test
    public void test_LoginSsoDecorator(){
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}


