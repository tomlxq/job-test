package com.tom;

/**
 * Created by tom on 2016/5/4.
 */
public class HelloApiStaticBeanFactory {
    /**
     * 使用静态工厂方式实例化Bean，使用这种方式除了指定必须的class属性，
     * 还要指定factory-method属性来指定实例化Bean的方法，
     * 而且使用静态工厂方法也允许指定方法参数，
     * spring IoC容器将调用此属性指定的方法来获取Bean
     * @param message
     * @return
     */
    public static HelloApi getInstance(String message) {
        //安需要bean实例化
        return new HelloApiImpl2("hello, static bean factory");
    }
}
