package com.tom.aop.spring;

/**
 * Created by tom on 2016/5/5.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 定义Advice
 * 实现MethodInterceptor接口定义环绕通知
 * Spring AOP
 */
public class ConcreteInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("在目标方法执行前实施增强");
        Object result = invocation.proceed();
        System.out.println("在目标方法执行后实施增强");
        return result;
    }
}
