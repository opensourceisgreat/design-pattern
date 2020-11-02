package org.liang.demo.design;

/**
 * @author liang
 * Date 2020/11/2-15:19
 * 静态内部类，线程安全，懒加载，非常推荐
 */
public class Singleton_03 {


    private static class SingletonHolder{
        private static Singleton_03 instance=new Singleton_03();

    }

    private Singleton_03(){}

    public static Singleton_03 getInstance(){
        return SingletonHolder.instance;
    }
}
