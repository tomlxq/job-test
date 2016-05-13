package com.tom.单例;

/**
 * 懒汉单例
 * Created by tom on 2016/5/4.
 */
public class Singleton {
    //Singleton通过将构造方法限定为private避免了类在外部被实例化，
    //在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
    private Singleton() {
    }

    private static Singleton instance = null;

    /**
     * 线程不安全
     *
     * @return
     */

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    /**
     * 线程安全，但每次使用都同步，影响性能，比较浪费资源
     *
     * @return
     */
    //加上同步
    public static synchronized Singleton getInstance1(){
        if(instance==null){instance=new Singleton();
        }
        return instance;
    }

    /**
     * 在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗
     * @return
     */
    //双重检查锁定
    public static  Singleton getInstance2(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    //静态内部类 上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响
    private final static class LazyInstance {
        private final static Singleton instance = new Singleton();
    }

    public final static Singleton getInstance3() {
        return LazyInstance.instance;
    }

    public void sayHello() {
        System.out.print("Hello world!\r\n");
    }
};

class Test {
    public static void main(String[] args) {
        Singleton.getInstance().sayHello();
        //Singleton s=new Singleton();
        //s.sayHello();
    }
}


