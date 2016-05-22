package com.tom.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tom on 2016/5/22.
 */
public class BusinessHandler implements InvocationHandler {
    private IBusiness bi = null;

    public BusinessHandler(IBusiness bi) {
        this.bi = bi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("事务、日志、权限等操作");
        method.invoke(bi, args);
        System.out.println("事务、日志、权限等操作");
        return bi;
    }
    public static void main(String[] args){
        IBusiness bi=new BusinessImpl();
        BusinessHandler bh=new BusinessHandler(bi);
        IBusiness proxy=(IBusiness) Proxy.newProxyInstance(bi.getClass().getClassLoader(),bi.getClass().getInterfaces(),bh);
        proxy.doBusiness();
    }

}
