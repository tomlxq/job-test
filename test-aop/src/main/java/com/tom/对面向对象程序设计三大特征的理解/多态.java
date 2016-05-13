package com.tom.对面向对象程序设计三大特征的理解;

/**
 * Created by tom on 2016/5/5.
 */
 interface 做事 {
    void 吃东西() ;
    void 吃东西(String name) ;
}

/**
 * 类中多个方法的重载叫多态，父子类中方法的覆盖也叫多态。
 因此多态有两种体现：一个是方法的重装，一个是方法的覆盖。
 */
public class 多态 implements 做事 {
    @Override
    public void 吃东西(){
       System.out.println("我是吃炒面!");
    }
    @Override
    public void 吃东西(String name){
        System.out.println(name+"是吃粥!");
    }

    public static void main(String[] arsg) {
        多态 test = new 多态();
        test.吃东西();
        test.吃东西("tom");
    }
}
