package com.tom.对面向对象程序设计三大特征的理解;

/**
 * Created by tom on 2016/5/5.
 */
class Father {
    String name;
    public Father() {
    }
    public void method() {
        System.out.println("Father");
    }
}

/**
 * 继承
 继承：当一个类继承了另一个类，通过关键字extends实现继承，被继承的叫父类，继承的类叫子类。
 在子类生成对象时，先调用父类不带参数的构造方法，在调用子类不带参数的构造方法。
 继承的特点：
 父类有的子类可以继承;父类没有的子类可以增加，父类有的子类可以改变；
 注意：父类的构造方法不能被子类继承，父类的私有方法不能被子类继承；父类的属性和方法可以被继承。
 */
public class 继承 extends Father{
    public void method()
    {
        System.out.println("Son");
    }
    public static void main(String[] arsg) {
        继承 test = new 继承();
        test.method();
    }
}
