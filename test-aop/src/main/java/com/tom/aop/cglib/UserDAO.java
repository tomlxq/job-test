package com.tom.aop.cglib;

/**
 * Created by tom on 2016/5/5.
 */
public class UserDAO {

    public void add(Object o) {
        System.out.println("UserDAO -> Add: " + o.toString());
    }

    public void get(Object o) {
        System.out.println("UserDAO -> Get: " + o.toString());
    }
}
