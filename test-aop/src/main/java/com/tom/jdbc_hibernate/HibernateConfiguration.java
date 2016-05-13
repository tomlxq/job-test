package com.tom.jdbc_hibernate;

/**
 * Created by tom on 2016/5/5.
 */

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.tom.jdbc_hibernate"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
    /**
     * 1.读取并解析配置文件
     * 2.读取并解析映射信息，创建SessionFactory
     * 3.打开Session
     * 4.创建事务Transaction
     * 5.持久化操作
     * 6.提交事务
     * 7.关闭Session
     * 8.关闭SessionFactory
     */
    @Autowired
    private Environment ev;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.tom.jdbc_hibernate"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ev.getRequiredProperty("mysql.jdbc.driverClassName"));
        dataSource.setUrl(ev.getRequiredProperty("mysql.jdbc.url"));
        dataSource.setUsername(ev.getRequiredProperty("mysql.jdbc.username"));
        dataSource.setPassword(ev.getRequiredProperty("mysql.jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
/*
validate               加载hibernate时，验证创建数据库表结构
create                  每次加载hibernate，重新创建数据库表结构
create-drop        加载hibernate时创建，退出是删除表结构
update                 加载hibernate自动更新数据库结构
*/

        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", ev.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", ev.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", ev.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
