package org.liang.demo.design.factory.impl;

import org.liang.demo.design.factory.ICacheAdapter;
import org.liang.demo.design.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liang
 * Date 2020/10/25-15:23
 */
public class JDKInvocationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.cacheAdapter = iCacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter,args);
    }
}
