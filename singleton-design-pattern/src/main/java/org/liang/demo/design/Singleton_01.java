package org.liang.demo.design;

/**
 * @author liang
 * Date 2020/11/2-15:15
 * 懒汉式加载，线程安全
 * 不推荐使用
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01(){}

    public synchronized static Singleton_01 getInstance(){
        if(null!=instance) return instance;
        instance=new Singleton_01();
        return instance;
    }
}
