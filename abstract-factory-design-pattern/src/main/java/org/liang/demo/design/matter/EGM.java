package org.liang.demo.design.matter;

import cn.hutool.log.StaticLog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:11
 * 模拟Redis集群，提供服务
 */
public class EGM {
    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String gain(String key) {
        StaticLog.info("EGM获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        StaticLog.info("EGM写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        StaticLog.info("EGM写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        StaticLog.info("EGM删除数据 key：{}", key);
        dataMap.remove(key);
    }
}
