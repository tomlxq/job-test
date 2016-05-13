package com.tom.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * Created by tom on 2016/5/3.
 */
public class TestAop {
    private static Logger logger= LoggerFactory.getLogger(TestAop.class);
    public static void main(String[] args) {
        IBusiness business = new BusinessImpl();
        IBusiness proxy = (IBusiness)Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(), new LogHandler(business));
        proxy.execute();
    }
}
