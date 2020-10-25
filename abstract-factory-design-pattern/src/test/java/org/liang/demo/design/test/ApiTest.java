package org.liang.demo.design.test;

import org.junit.Test;
import org.liang.demo.design.CacheService;
import org.liang.demo.design.factory.impl.EGMCacheAdapter;
import org.liang.demo.design.factory.impl.IIRCacheAdapter;
import org.liang.demo.design.factory.impl.JDKProxy;
import org.liang.demo.design.impl.CacheServiceImpl;

/**
 * @author liang
 * Date 2020/10/25-15:53
 */
public class ApiTest {

    @Test
    public void test_CacheService() throws Exception {

        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

    }
}
