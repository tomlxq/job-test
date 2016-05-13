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

 AOP联盟为通知Advice定义了org.aopalliance.aop.Advice接口,
 Spring在Advice的基础上,根据通知在目标方法的连接点位置,扩充为以下五类:
 通知	接口	描述
 前置通知	MethodBeforeAdvice	在目标方法执行前实施增强
 后置通知	AfterReturningAdvice	…执行后实施增强
 环绕通知	MethodInterceptor	..执行前后实施增强
 异常抛出通知	ThrowsAdvice	…抛出异常后实施增强
 引介通知	IntroductionInterceptor	在目标类中添加新的方法和属性(少用)
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
