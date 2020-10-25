package org.liang.demo.design;

import java.util.concurrent.TimeUnit;

/**
 * @author liang
 * Date 2020/10/25-15:06
 */
public interface CacheService {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
