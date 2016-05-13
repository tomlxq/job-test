package com.tom;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.StringTokenizer;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by tom on 2016/5/4.
 */
//String类是final类故不可以继承。
//public class TestString extends String {
public class TestString extends BaseUnitTest {
    @Test
    public void testString() {
        /**
         * 这两行代码执行后，原始的String对象中的内容到底变了没有？
         没有。因为String被设计成不可变(immutable)类，所以它的所有对象都是不可变对象。
         在这段代码中，s原先指向一个String对象，内容是 "Hello"，
         然后我们对s进行了+操作，那么s所指向的那个对象是否发生了改变呢？
         答案是没有。这时，s不指向原来那个对象了，而指向了另一个 String对象，
         内容为"Hello world!"，原来那个对象还存在于内存之中，只是s这个引用变量不再指向它了。

         如果经常对字符串进行各种各样的修改，或者说，不可预见的修改，
         那么使用String来代表字符串的话会引起很大的内存开销。
         因为 String对象建立之后不能再改变，所以对于每一个不同的字符串，
         都需要一个String对象来表示。这时，应该考虑使用StringBuffer类，它允许修改，
         而不是每个不同的字符串都要生成一个新的对象。并且，这两种类的对象转换十分容易。
         */
        String s = "hello";
        s = s + " world";
        logger.debug(s);
    }

    @Test
    public void testString2() {
        /**
         * 创建了几个String Object?二者之间有什么区别？
         两个或一个，”xyz”对应一个对象，这个对象放在字符串常量缓冲区，常量”xyz”不管出现多少遍，
         都是缓冲区中的那一个。New String每写一遍，就创建一个新的对象，
         它一句那个常量”xyz”对象的内容来创建出一个新String对象。
         如果以前就用过’xyz’，这句代表就不会创建”xyz”自己了，直接从缓冲区拿。
         */
        String s = new String("xyz");
    }

    @Test
    public void testStringBuffer() {
        /**
         * AVA平台提供了两个类：String和StringBuffer，它们可以储存和操作字符串，
         * 即包含多个字符的字符数据。这个String类提供了数值不可改变的字符串。
         * 而这个StringBuffer类提供的字符串进行修改。当你知道字符数据要改变的时候你就可以使用StringBuffer。
         * 典型地，你可以使用StringBuffers来动态构造字符数据。
         * 另外，String实现了equals方法，new String(“abc”).equals(newString(“abc”)的结果为true,
         * 而StringBuffer没有实现equals方法，
         * 所以，new StringBuffer(“abc”).equals(newStringBuffer(“abc”)的结果为false。
         *
         * //String覆盖了equals方法和hashCode方法，
         // 而StringBuffer没有覆盖equals方法和hashCode方法，
         // 所以，将StringBuffer对象存储进Java集合类中时会出现问题。
         */
        Date d = new Date();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sbf.append(i);
        }
        System.out.println("StringBuffer所花时间为:" + (new Date().getTime() - d.getTime()));

        d = new Date();
        String sbf1 = new String();
        for (int i = 0; i < 10000; i++) {
            sbf1 = sbf1 + i;
        }
        System.out.println("String 所花时间为:" + (new Date().getTime() - d.getTime()));
        Assert.assertEquals((new String("abc")).equals(new String("abc")), true);
        Assert.assertEquals((new StringBuffer("abc")).equals(new StringBuffer("abc")), false);
    }

    @Test
    public void testSplit() {
        //如何把一段逗号分割的字符串转换成一个数组?
        String orgStr = "a,b.c";
        String[] result = orgStr.split(",");
        logger.debug("{}", StringUtils.join(result));
        StringTokenizer tokener = new StringTokenizer(orgStr, ",");
        String[] result2 = new String[tokener.countTokens()];
        int i = 0;
        while (tokener.hasMoreTokens()) {
            result2[i++] = tokener.nextToken();
        }
        logger.debug("{}",StringUtils.join(result2));

    }
/*    //https://www.douban.com/note/488515460/
    Spring4.1新特性——Spring缓存框架增强
    http://jinnianshilongnian.iteye.com/blog/2105367?utm_source=tuicool&utm_medium=referral
    【第三章】 DI 之 3.1 DI的配置使用 ——跟我学spring3
    http://jinnianshilongnian.iteye.com/blog/1415277
    */
}


class Demo {
    /**
     * s = new String("Initial Value");
     * 后者每次都会调用构造器，生成新对象，性能低下且内存开销大，并且没有意义，
     * 因为String对象不可改变，所以对于内容相同的字符串，只要一个String对象来表示就可以了。
     * 也就说，多次调用上面的构造器创建多个对象，他们的String类型属性s都指向同一个对象。
     */

    private String s;

    Demo() {
        s = "initial s";
    }
}