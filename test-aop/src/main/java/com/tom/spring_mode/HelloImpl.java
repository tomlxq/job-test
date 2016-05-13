package com.tom.spring_mode;

/**
 * Created by tom on 2016/5/5.
 */
public class HelloImpl implements Hello {
    String message;


    HelloImpl() {
        this.message = "猜猜我是谁";
    }

    HelloImpl(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(this.message);
    }
}
