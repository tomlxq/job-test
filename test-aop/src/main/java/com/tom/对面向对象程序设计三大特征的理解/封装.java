package com.tom.对面向对象程序设计三大特征的理解;

/**
 * Created by tom on 2016/5/5.
 */

/**
 * 封装：简单地说就是把数据和方法放在一个类里面包装起来。
 */
public class 封装 {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] arsg) {
        int x = 3;
        int y = 5;
        封装 test = new 封装();
        int m = test.add(x, y);
        System.out.println(m);
    }

}
