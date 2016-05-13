package com.tom.aop.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tom on 2016/5/5.
 * AOP实现

 Spring AOP代理实现有两种:JDK动态代理和Cglib框架动态代理, JDK动态代理可以参考博客代理模式的动态代理部分,
 在这里仅介绍CGLib框架实现.
 cglib 动态代理
 cglib(Code Generation Library)是一个开源/高性能/高质量的Code生成类库,可以在运行期动态扩展Java类与实现Java接口.
 cglib比java.lang.reflect.Proxy更强的在于它不仅可以接管接口类的方法,还可以接管普通类的方法
 */
public class CGLibProxyFactory {

    private Object target;


    public CGLibProxyFactory(Object target) {
        this.target = target;
    }


    private Callback callback = new MethodInterceptor() {


        /**
          *
          * @param obj   代理对象
          * @param method    当期调用方法
          * @param args  方法参数
          * @param proxy 被调用方法的代理对象(用于执行父类的方法)
          * @return
          * @throws Throwable
          */
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

            // 前置增强
            System.out.println("前置增强+ Before Advice ...");

            // 执行目标方法
            //Object result = method.invoke(target, args);
            System.out.println("执行目标方法 ...");
            Object result = proxy.invoke(target, args);

            // 后置增强
            System.out.println("后置增强+ After Advice ...");

            return result;
        }
    };


    public Object createProxy() {

        // 1. 创建Enhancer对象
        Enhancer enhancer = new Enhancer();

        // 2. cglib创建代理, 对目标对象创建子对象
        enhancer.setSuperclass(target.getClass());

        // 3. 传入回调接口, 对目标增强
        enhancer.setCallback(callback);

        return enhancer.create();
    }



    public static void main(String[] args) {
        UserDAO proxy = (UserDAO) new CGLibProxyFactory(new UserDAO()).createProxy();
        proxy.get("hello");
        proxy.add("world");
    }
}
