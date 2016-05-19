package spring_ioc;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tom on 2016/5/18.
 */
public class BeanFactory {

    static Logger log = LoggerFactory.getLogger(BeanFactory.class);
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    /**
     * bean工厂的初始化
     *
     * @param xml
     */
    public void init(String xml) {
        try {
            //读取指定的配置文件
            SAXReader reader = new SAXReader();
            //从class目录下获取指定的配置文件
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(xml);

            //读取xml文件
            Document document = reader.read(inputStream);
            //获取跟节点
            Element root = document.getRootElement();
            //遍历bean节点
            Element foo;
            for (Iterator iteBean = root.elementIterator("bean"); iteBean.hasNext(); ) {
                foo = (Element) iteBean.next();
                //获取bean的属性id和class
                Attribute id = foo.attribute("id");
                Attribute cls = foo.attribute("class");
                //利用java反射机制，通过class的名称获取Class对象
                log.debug("{}", cls.getText());
                Class bean = Class.forName(cls.getText());
                //获取对应class信息
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                //获取其属性描述
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
                //设置值的方法
                Method mSet = null;
                //创建一个对象(创建此 Class 对象所表示的类的一个新实例。如同用一个带有一个空参数列表的 new 表达式实例化该类。如果该类尚未初始化，则初始化这个类。)
                Object obj = bean.newInstance();

                //遍历该bean的property属性
                for (Iterator iteProperty = foo.elementIterator("property"); iteProperty.hasNext(); ) {
                    Element elementProperty = (Element) iteProperty.next();
                    //获取该property的name属性
                    Attribute name = elementProperty.attribute("name");
                    //读取该属性值
                    String value = elementProperty.attribute("value").getText();
                    //String value = null;
                    //获取该property的子元素value的值
                    //for(Iterator iteValue = elementProperty.elementIterator("value");iteValue.hasNext();){
                    //      Element elementValue = (Element)iteValue.next();
                    //      value = elementValue.getText();
                    //      break;
                    //}
                    for (int k = 0; k < pd.length; k++) {
                        log.info(pd[k].getName());
                        if (pd[k].getName().equalsIgnoreCase(name.getText())) {
                            mSet = pd[k].getWriteMethod();//
                            log.info(mSet.getName());
                            //利用Java的反射机制调用对象的某个set方法，并将值设置进去
                            mSet.invoke(obj, value);//通过invoke方法来调用特定对象的特定方法，实现的原理都是基于Java的反射机制
                        }
                    }
                }
                //将对象放入beanMap中，其中key为id值，value为对象
                beanMap.put(id.getText(), obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过bean的id获取bean的对象.
     *
     * @param beanName bean的id
     * @return 返回对应对象
     */
    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }

    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        factory.init("config.xml");
        JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
        System.out.println("userName=" + javaBean.getUsername());
        System.out.println("password=" + javaBean.getPassword());
    }
}