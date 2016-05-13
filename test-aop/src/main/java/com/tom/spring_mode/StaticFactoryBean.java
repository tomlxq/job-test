package com.tom.spring_mode;

/**
 * Created by tom on 2016/5/5.
 */
import java.util.Random;
public class StaticFactoryBean {
    public static Integer createRandom() {
        return new Integer(new Random().nextInt());
    }
}