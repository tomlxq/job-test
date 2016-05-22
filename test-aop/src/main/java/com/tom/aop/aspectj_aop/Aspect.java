package com.tom.aop.aspectj_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by tom on 2016/5/5.
 */
public class Aspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(Aspect.class);

    /**
     * 无返回值
     */
    public void before1() {
        System.out.println("前置增强before1");
    }

    /**
     * 还可以传入连接点参数 JoinPoint
     *
     * @param point
     */
    public void before2(JoinPoint point) {
        System.out.printf("前置增强before2 %s%n", point.getKind());
    }

    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.printf("环绕增强Begin method: %s, args: %s%n", point.toShortString(), Arrays.toString(point.getArgs()));
        Object result = point.proceed(point.getArgs());//如果有错误这儿会记录在就用程序中用了try{} catch (Exception e) {}
        System.out.printf("环绕增强After result: %s%n", result);
        return result;
    }

    public void afterThrowing(JoinPoint point, Throwable ex) {
        //仅错误外抛时，才显示错误　如public Integer delete(Integer param) throws Exception {}
        String message = new StringBuilder("method ").append(point.getSignature().getName()).append(" error").toString();
        System.out.println(message);
        LOGGER.error("{},", message, ex);
    }

    public void afterReturning(JoinPoint point, Object result) {
        System.out.printf("后置增强, 结果为 %s%n", result);
    }

    public void after(JoinPoint point) {
        System.out.println("最终通知, 释放资源");
    }

}