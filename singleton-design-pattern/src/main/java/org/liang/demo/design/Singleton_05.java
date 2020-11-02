package org.liang.demo.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liang
 * Date 2020/11/2-15:31
 * 线程安全
 */
public class Singleton_05 {

    public static final AtomicReference<Singleton_05> INSTANCE = new AtomicReference<>();
    private static Singleton_05 instance;

    private Singleton_05(){}
    public static Singleton_05 getInstance(){
        for (;;){
            Singleton_05 instance=INSTANCE.get();
            if (null!=instance) return instance;
            INSTANCE.compareAndSet(null,new Singleton_05());
            return INSTANCE.get();
        }
    }
}
