package org.liang.demo.design.factory.impl;

import org.liang.demo.design.factory.ICacheAdapter;
import org.liang.demo.design.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:16
 */
public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
