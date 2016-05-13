package com.tom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Created by tom on 2016/5/4.
 */

public class TestIoc extends BaseUnitTest{


    // @Autowired
    // HelloApi helloApi;
    @Test
    public void testHelloWorld() {
        //1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloApi helloApi = context.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
        String dir = new File(this.getClass().getResource("/com/tom").getFile()).getAbsolutePath() + "/../../../classes";
        logger.debug(dir);
        File file = new File(dir, "application.xml");
        Resource resource = new FileSystemResource(file);
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        HelloApi helloApi2 = beanFactory.getBean("hello", HelloApi.class);
        //3、执行业务逻辑
        helloApi2.sayHello();
    }

    @Test
    public void testHelloWorld2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloApi.xml");
        HelloApi hello = context.getBean(HelloApiImpl.class);
        hello.sayHello();
    }

    @Test
    public void test_Id_Name_Alias() {
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("application.xml");
        //根据id获取bean
        HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
        bean1.sayHello();
        //根据别名获取bean
        HelloApi bean2 = beanFactory.getBean("alias1", HelloApi.class);
        bean2.sayHello();
        //根据id获取bean
        HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
        bean3.sayHello();
        String[] bean3Alias = beanFactory.getAliases("bean3");
        //因此别名不能和id一样，如果一样则由IoC容器负责消除冲突
        Assert.assertEquals(0, bean3Alias.length);
    }

    //Spring IoC容器即能使用默认空构造器也能使用有参数构造器两种方式创建Bean
    @Test
    public void test_Constructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloApi1.xml");
        HelloApi helloApi1 = (HelloApi) context.getBean("bean1");
        helloApi1.sayHello();
        HelloApi helloApi2 = (HelloApi) context.getBean("bean2");
        helloApi2.sayHello();
    }
    @Test
    public void test_静态工厂实例化() {
        ApplicationContext context = new ClassPathXmlApplicationContext("helloApi1.xml");
        HelloApi helloApi1 = (HelloApi) context.getBean("bean3");
        helloApi1.sayHello();
    }

}