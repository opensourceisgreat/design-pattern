package org.liang.demo.design.matter;

import cn.hutool.log.StaticLog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:07
 * 模拟单机redis存取数据
 */
public class RedisUtils {
    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String get(String key) {
        StaticLog.info("Redis获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        StaticLog.info("Redis写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        StaticLog.info("Redis写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        StaticLog.info("Redis删除数据 key：{}", key);
        dataMap.remove(key);
    }
}
