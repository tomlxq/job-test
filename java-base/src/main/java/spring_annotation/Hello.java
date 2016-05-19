package spring_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: TOM
 * Date: 2016/5/19
 * email: beauty9235@gmail.com
 * Time: 9:54
 * 注解声明
 */
public class Hello {
    // 普通的方法
    public void sayHello() {
        System.out.println("hello, kitty!");
    }

    //使用注解但没有传入参数
    @HelloAnnotation()
    public void sayHello1(String value) {
        System.out.println(value);
    }

    //使用注解并传入参数的方法
    @HelloAnnotation("hello, jim!")
    public void sayHello2(String value) {
        System.out.println(value);
    }

    /**
     * 操作使用注解元素的代码
     */
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Hello element = new Hello(); // 初始化一个实例，用于方法调用
        Method[] methods = Hello.class.getDeclaredMethods(); // 获得所有方法
        for (Method method : methods) {
            if (method.getName().equals("main")) continue; //这儿排除main方法
            System.out.println(method.getName());
            HelloAnnotation annotationTmp = null;
            if ((annotationTmp = method.getAnnotation(HelloAnnotation.class)) != null) // 检测是否使用了我们的注解
                method.invoke(element, annotationTmp.value()); // 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
            else
                method.invoke(element);//如果没有使用我们的注解，我们就需要使用普通的方式来调用方法了 sayHello()
        }
    }
}
