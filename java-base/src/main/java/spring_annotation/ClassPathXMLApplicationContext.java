package spring_annotation;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: TOM
 * Date: 2016/5/19
 * email: beauty9235@gmail.com
 * Time: 11:39
 */
public class ClassPathXMLApplicationContext {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    Map<String, Object> sigletions = new HashMap<String, Object>();

    public ClassPathXMLApplicationContext(String fileName) {
        //读取配置文件中管理的bean
        this.readXML(fileName);
        //注解处理器
        this.annotationInject();
    }

    /**
     * 读取Bean配置文件
     *
     * @param xml
     * @return
     */
    @SuppressWarnings("unchecked")
    public void readXML(String xml) {
        SAXReader saxReader = new SAXReader();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(xml);
            Document document = saxReader.read(inputStream);
            Element beans = document.getRootElement();
            for (Iterator<Element> beansList = beans.elementIterator();
                 beansList.hasNext(); ) {
                Element element = beansList.next();
                Attribute id = element.attribute("id");
                Attribute cls = element.attribute("class");
                //下面是完成對field、method的注入
                logger.info("{} {}", id.getText(), cls.getText());
                sigletions.put(id.getText(), Class.forName(cls.getText()).newInstance());

            }
        } catch (Exception e) {
            logger.info("读取配置文件出错....{}", e.getMessage());
        }
    }

    /**
     * 注解处理器
     * 如果注解TomResourceAnnotation配置了name属性，则根据name所指定的名称获取要注入的实例引用，
     * 如果注解TomResourceAnnotation;没有配置name属性，则根据属性所属类型来扫描配置文件获取要
     * 注入的实例引用
     */
    public void annotationInject() {
        for (String beanName : sigletions.keySet()) {
            Object bean = sigletions.get(beanName);
            if (bean != null) {
                this.propertyAnnotation(bean);
                this.fieldAnnotation(bean);
            }
        }
    }

    /**
     * 处理在set方法加入的注解
     *
     * @param bean 处理的bean
     */
    public void propertyAnnotation(Object bean) {
        try {
            //获取其属性的描述
            PropertyDescriptor[] ps =
                    Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor proderdesc : ps) {
                //获取所有set方法
                Method setter = proderdesc.getWriteMethod();
                //判断set方法是否定义了注解
                if (setter != null && setter.isAnnotationPresent(TomResourceAnnotation.class)) {
                    //获取当前注解，并判断name属性是否为空
                    TomResourceAnnotation resource = setter.getAnnotation(TomResourceAnnotation.class);
                    String name = "";
                    Object value = null;
                    if (resource.name() != null && !"".equals(resource.name())) {
                        //获取注解的name属性的内容
                        name = resource.name();
                        value = sigletions.get(name);
                    } else { //如果当前注解没有指定name属性,则根据类型进行匹配
                        for (String key : sigletions.keySet()) {
                            //判断当前属性所属的类型是否在配置文件中存在
                            if (proderdesc.getPropertyType().isAssignableFrom(sigletions.get(key).getClass())) {
                                //获取类型匹配的实例对象
                                value = sigletions.get(key);
                                break;
                            }
                        }
                    }
                    //允许访问private方法
                    setter.setAccessible(true);
                    //把引用对象注入属性
                    setter.invoke(bean, value);
                }
            }
        } catch (Exception e) {
            logger.info("set方法注解解析异常..........");
        }
    }

    /**
     * 处理在字段上的注解
     *
     * @param bean 处理的bean
     */
    public void fieldAnnotation(Object bean) {
        try {
            //获取其全部的字段描述
            Field[] fields = bean.getClass().getFields();
            for (Field f : fields) {
                logger.debug("{}", f.getName());
                if (f != null && f.isAnnotationPresent(TomResourceAnnotation.class)) {
                    TomResourceAnnotation resource = f.getAnnotation(TomResourceAnnotation.class);
                    String name = "";
                    Object value = null;
                    if (resource.name() != null && !"".equals(resource.name())) {
                        name = resource.name();
                        value = sigletions.get(name);
                    } else {
                        for (String key : sigletions.keySet()) {
                            //判断当前属性所属的类型是否在配置文件中存在
                            if (f.getType().isAssignableFrom(sigletions.get(key).getClass())) {
                                //获取类型匹配的实例对象
                                value = sigletions.get(key);
                                break;
                            }
                        }
                    }
                    //允许访问private字段
                    f.setAccessible(true);
                    //把引用对象注入属性
                    f.set(bean, value);
                }
            }
        } catch (Exception e) {
            logger.info("字段注解解析异常..........");
        }
    }

    /**
     * 获取Map中的对应的bean实例
     *
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        return sigletions.get(beanId);
    }
}
