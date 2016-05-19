package spring_ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 2016/5/18.
 */
public class SetValueByReflectionLoop {
    static Logger log = LoggerFactory.getLogger(BeanFactory.class);

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IntrospectionException {
        //这个map对象用来模拟对属性文件解析获了的属性名与值
        Map<String, Object> map = new HashMap<>();
        map.put("username", "tomLuo");
        map.put("password", "954");

        Class bean = Class.forName("spring_ioc.JavaBean");
        Object obj = bean.newInstance();
        //获取对应class信息
        BeanInfo info = Introspector.getBeanInfo(bean);
        // 遍历指定类的属性
        PropertyDescriptor[] propertys = info.getPropertyDescriptors();
        for (int j = 0; j < propertys.length; j++) {
            System.out.println("属性：" + propertys[j].getName());
        }
        //获取其属性描述
        java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
        Method mSet = null;
        for (int k = 0; k < pd.length; k++) {
            if (map.containsKey(pd[k].getName())) {
                Object value=map.get(pd[k].getName());//将对应的属性值取出来
                mSet = pd[k].getWriteMethod();
                log.info("{} {} {}", pd[k].getName(), pd[k].getWriteMethod().getName(), pd[k].getReadMethod().getName());//password setPassword getPassword
                mSet.invoke(obj, value);//利用反射将567注入到bean　这儿实验将每个set方法的值都设置为567
            }
        }
        //将对象放入beanMap中，其中key为id值，value为对象
        JavaBean javaBean1 = (JavaBean) obj;
        System.out.println("userName=" + javaBean1.getUsername());
        System.out.println("password=" + javaBean1.getPassword());

    }
}
