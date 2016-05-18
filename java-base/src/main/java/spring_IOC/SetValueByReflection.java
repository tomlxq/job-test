package spring_IOC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tom on 2016/5/18.
 */
public class SetValueByReflection {
    /**
     * 实例化一个类，利用反射，将其注入值
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JavaBean bean = new JavaBean();
        //获取指定类的指定方法，
        Class c = Class.forName("spring_IOC.JavaBean");
        Method method = c.getMethod("setUsername", new Class[]{String.class});
        //对带有指定参数的指定对象调用由此 Method 对象表示的底层方法,调用对象javaBean的setuserName方法，参数为"hello world"
        method.invoke(bean, "hello world");
        System.out.println(bean.getUsername());
    }
}
