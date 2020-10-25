package org.liang.demo.design.factory.impl;

import org.liang.demo.design.factory.ICacheAdapter;
import org.liang.demo.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:16
 */
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }

}
