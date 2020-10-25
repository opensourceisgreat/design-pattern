package org.liang.demo.design.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:15
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
