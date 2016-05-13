package com.tom.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tom on 2016/5/3.
 */
public class LogHandler implements InvocationHandler {
    private Logger logger= LoggerFactory.getLogger(LogHandler.class);
    private Object delegate;

    public LogHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        try {
            logger.debug("开启日志记录 {}", method);
            obj = method.invoke(delegate, args);
            logger.debug("结束日志记录 {}", method);
        } catch (Exception e) {
        }
        return obj;
    }
}
