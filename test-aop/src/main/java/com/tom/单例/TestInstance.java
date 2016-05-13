package com.tom.单例;

/**
 * Created by tom on 2016/5/4.
 * 懒汉式双重检查模型
 */
public class TestInstance {
    private TestInstance() {
    }

    private static TestInstance instance = null;

    public static  TestInstance getInstance() {
        if (instance == null) {
            synchronized (TestInstance.class) {//只在第一次实例化时同步
                if (instance == null) {
                    instance = new TestInstance();
                }
            }
        }
        return instance;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo(){
        System.out.println(this.name);
    }
}
class Test3{
    public static void main(String[] args){
        TestInstance t1=TestInstance.getInstance();
        t1.setName("hello");
        TestInstance t2=TestInstance.getInstance();
        t2.setName("world");
        t1.printInfo();
        t2.printInfo();
        if(t1==t1){
            System.out.println("同一个实例");
        }else{
            System.out.println("不同实例");
        }
    }
}
