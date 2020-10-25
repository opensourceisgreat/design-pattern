package org.liang.demo.design.factory.impl;

import org.liang.demo.design.factory.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author liang
 * Date 2020/10/25-15:52
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
