package com.tom.bean_life_cycle;

/**
 * Created by tom on 2016/5/5.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * spring bean的生命周期是怎样的
 * ean的完整生命周期经历了各种方法调用，这些方法可以划分为以下几类：
 1、Bean自身的方法：
 　  这个包括了Bean本身调用的方法和通过配置文件中<bean>的init-method和destroy-method指定的方法
 2、Bean级生命周期接口方法：
 　  这个包括了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这些接口的方法
 3、容器级生命周期接口方法：
 　  这个包括了InstantiationAwareBeanPostProcessor 和 BeanPostProcessor 这两个接口实现，一般称它们的实现类为“后处理器”。
 4、工厂后处理器接口方法：
 　  这个包括了AspectJWeavingEnabler, ConfigurationClassPostProcessor, CustomAutowireConfigurer等等非常有用的工厂后处理器　　
    接口的方法。工厂后处理器也是容器级的。在应用上下文装配配置文件之后立即调用。
 */

/**
 * 首先是一个简单的Spring Bean，调用Bean自身的方法和Bean级生命周期接口方法，
 为了方便演示，它实现了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这4个接口，
 【对于BeanFactoryAware和BeanNameAware接口，第一个接口让bean感知容器（即BeanFactory实例，从而以此获取该容器配置的其他bean对象），
 而后者让bean获得配置文件中对应的配置名称。在一般情况下用户不需要关心这两个接口。
 如果bean希望获得容器中的其他bean，可以通过属性注入的方式引用这些bean。
 如果bean希望在运行期获知在配置文件中的Bean名称，可以简单的将名称作为属性注入
 综上所述，我们认为除非编写一个基于spring之上的扩展框架插件或者子项目之类的东西，否则用户完全可以抛开以上4个bean生命周期的接口类

 但BeanPostProcessor接口却不一样，它不要求bean去继承它，它可以完全像插件一样注册到spring容器中，为容器提供额外的功能。
 spring充分利用了BeanPostProcessor对bean进行加工处理（SpringAOP以此为基础)】

 同时有2个方法，对应配置文件中<bean>的init-method和destroy-method。
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private String phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}