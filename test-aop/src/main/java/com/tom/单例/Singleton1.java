package com.tom.单例;

/**
 * Created by tom on 2016/5/4.
 */
//饿汉式单例模式　
//饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
public class Singleton1 {
    private Singleton1() {
    }
    private final static Singleton1 instance=new Singleton1();
    public final static Singleton1 getInstance(){
        return instance;
    }
    public void sayHello() {
        System.out.print("Hello world2!\r\n");
    }
    ;
}
class Test2{
    public static void main(String[] args){
        Singleton1.getInstance().sayHello();
        //Singleton s=new Singleton();
        //s.sayHello();
    }
}