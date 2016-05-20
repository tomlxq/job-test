package spring_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tom on 2016/5/18.
 */
@Target({ElementType.TYPE, ElementType.METHOD})//表示该注解用于什么地方
@Retention(RetentionPolicy.RUNTIME)//表示在什么级别保存改注解信息
//@Documented表示将此注解包含在javadoc中
//@Inherited表示允许子类继承父类中的注解
public @interface NeedLogin {
    boolean value() default true;

    boolean guest() default true;
}
