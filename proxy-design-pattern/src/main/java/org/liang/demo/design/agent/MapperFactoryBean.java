package org.liang.demo.design.agent;

import cn.hutool.log.StaticLog;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author liang
 * Date 2020/10/22-20:05
 *
 */

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {

        InvocationHandler handler=(proxy,method,args)->{
            Select select = method.getAnnotation(Select.class);
            StaticLog.info("SQL:{}",select.value().replace("#{uId}",args[0].toString()));

            return args[0]+",模拟查询数据返回结果";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
