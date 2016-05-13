package com.tom.aop.aspectj_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by tom on 2016/5/5.
 * 前置通知小结
 前置通知会保证在目标方法执行前执行;
 前置通知默认不能阻止目标方法执行(但如果通知抛出异常,则目标方法无法执行);
 可以通过JoinPoint参数获得当前拦截对象和方法等信息.
 */
public class Aspect {

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

    public void afterReturning(JoinPoint point, Object result) {
        System.out.printf("后置增强, 结果为 %s%n", result);
    }

    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.printf("环绕前置增强 method: %s, args: %s%n", point.toShortString(), Arrays.toString(point.getArgs()));
        Object result = point.proceed(point.getArgs());
        System.out.printf("环绕后置增强 result: %s%n", result);
        return result;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Aspect.class);

    public void afterThrowing(JoinPoint point, Throwable ex) {
        String message = new StringBuilder("method ").append(point.getSignature().getName()).append(" error").toString();
        System.out.println(message);

        LOGGER.error("{},", message, ex);
    }

    public void after(JoinPoint point) {
        System.out.println("最终通知, 释放资源");
    }
}