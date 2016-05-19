package spring_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tom on 2016/5/18.
 */
public class Login {
    @NeedLogin(value = false, guest = true)
    public void login(boolean value,boolean guest) {

    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        Login element = new Login(); // 初始化一个实例，用于方法调用
        Method[] methods = Login.class.getDeclaredMethods(); // 获得所有方法

        for (Method method : methods) {
            NeedLogin annotationTmp = null;
            if ((annotationTmp = method.getAnnotation(NeedLogin.class)) != null) // 检测是否使用了我们的注解
                method.invoke(element, annotationTmp.value(),annotationTmp.guest()); // 如果使用了我们的注解，我们就把注解里的"paramValue"参数值作为方法参数来调用方法
            else
                method.invoke(element, true,true); // 如果没有使用我们的注解，我们就需要使用普通的方式来调用方法了
        }
    }
}
