package org.liang.demo.design.impl;

import org.liang.demo.design.CacheService;
import org.liang.demo.design.matter.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:07
 */
public class CacheServiceImpl implements CacheService {
    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
