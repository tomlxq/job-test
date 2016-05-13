package com.tom.jdk15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by tom on 2016/5/3.
 */
import static java.lang.Math.*;

public class TestJdk15 {
    final static Logger logger = LoggerFactory.getLogger(TestJdk15.class);

    //泛型(Generic)
    public void TestGeneric() {
        Collection c = new ArrayList();
        c.add(new Date());
    }

    ;

    //For-Each循环得加入简化了集合的遍历
    public void TestForEach() {
        Integer[] intAry = {1, 2, 3};
        List<Integer> j = Arrays.asList(intAry);
        for (Iterator i = j.iterator(); i.hasNext(); ) {
            logger.debug("{}", j);
        }
        for (Integer myObject : j) {
            logger.debug("{}", j);
        }
    }

    public void TestAutoboxingUnboxing() {
        int i = 3;
        Collection c = new ArrayList<>();
        c.add(i);//自动装包，变成integer
        Integer j = new Integer(2);
        c.add(j + 2);//j自动拆包，变成int
        logger.debug("{}", c);
    }

    //枚举(Enums)
    public enum color {
        RED, BLUE, WHITE
    }

    public static void testEnum() {
        logger.debug("{}", color.BLUE);
        for (color c : color.values()) {
            logger.debug("{}", c);
        }
    }

    public static void testArgs(Object... args) {
        for (Object c : args) {
            logger.debug("{}", c);
        }
    }

    //可变参数(Varargs)
    public static void testVarargs() {
        testArgs("zhangshan", "lishi", "wangwu");
        testArgs("zhangshan");
        testArgs("zhangshan", "lishi");
    }

    public static void testJava的反射包() {
        Class<?> c = null;
        try {
            c = Class.forName("com.tom.jdk15.C");
        } catch (ClassNotFoundException e) {
            logger.debug("{}", e);
        }
        //在引入可变参数以后，Java的反射包也更加方便使用了。对于
        //c.getMethod("test", new Object[0]).invoke(c.newInstance(), new Object[0]);
        //现在我们可以这样写了
        try {
            c.getMethod("test").invoke(c.newInstance());//，这样的代码比原来清楚了很多。
        } catch (IllegalAccessException e) {
            logger.debug("{}", c);
        } catch (InvocationTargetException e) {
            logger.debug("{}", c);
        } catch (NoSuchMethodException e) {
            logger.debug("{}", c);
        } catch (InstantiationException e) {
            logger.debug("{}", c);
        }
    }

    public static void test引入静态包() {
        double r = sin(PI * 2); //无需再写r = Math.sin(Math.PI);
        logger.debug("引入静态包 {}", r);
    }

    public static void main(String[] args) {
        testJava的反射包();
        test引入静态包();
    }

}

class C {
    public void test() {
        System.out.print("Just say hi!");
    }
}
