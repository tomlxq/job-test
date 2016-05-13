package com.tom.aop.aspectj_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by tom on 2016/5/5.
 */
@Aspect
@Component
public class CustomAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAspect.class);
    @Pointcut("execution(* com.tom.aop.spring.*ServiceImpl.*(..))")
    public void pointcut() {
    }

    //参考http://sishuok.com/forum/posts/list/281.html
    //@Before("execution(* com.tom.aop.spring.*ServiceImpl.*(..))")
    @After("CustomAspect.pointcut()")
    public void before(JoinPoint point) {
        System.out.printf("前置增强before2 %s%n", point.getKind());
    }

    @AfterReturning(value = "execution(* com.tom.aop.spring.*ServiceImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint point, Object result) {
        System.out.printf("后置增强, 结果为 %s%n", result);
    }

    @Around("execution(* com.tom.aop.spring.*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed(point.getArgs());
        long time = System.currentTimeMillis() - start;

        System.out.printf("method %s invoke consuming %d ms%n", point.toLongString(), time);

        return result;
    }
    @AfterThrowing(value = "execution(* com.tom.aop.spring.*ServiceImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint point, Throwable ex) {
        String message = new StringBuilder("method ").append(point.getSignature().getName()).append(" error").toString();
        System.out.println(message);

        LOGGER.error("{},", message, ex);
    }
}

