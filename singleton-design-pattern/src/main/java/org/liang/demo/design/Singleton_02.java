package org.liang.demo.design;

/**
 * @author liang
 * Date 2020/11/2-15:17
 * 饿汉式，线程安全
 */
public class Singleton_02 {
    private static Singleton_02 instance = new Singleton_02();

    private Singleton_02(){}

    public static Singleton_02 getInstance(){
        return instance;
    }

}
