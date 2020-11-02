package org.liang.demo.design;

/**
 * @author liang
 * Date 2020/11/2-15:27
 * DCL,双重检锁
 */
public class Singleton_04 {
    private volatile static Singleton_04 instance;

    private Singleton_04(){}

    public static Singleton_04 getInstance(){
        if(null!=instance) return instance;
        synchronized (Singleton_04.class){
            if (null == instance) {
                instance=new Singleton_04();
            }
        }
        return instance;
    }
}
