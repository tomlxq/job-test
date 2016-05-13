import com.tom.spring_mode.Hello;
import com.tom.spring_mode.HelloImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tom on 2016/5/5.
 */
public class TestSpringMode extends BaseTest {
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring_mode.xml");
        Hello h= context.getBean("singletonBean",HelloImpl.class);
        h.sayHello();
        Hello h2= context.getBean("itxxzBean",HelloImpl.class);
        h2.sayHello();

        //调用getBean()时,返回随机数.如果没有指定factory-method,会返回StaticFactoryBean的实例,即返回工厂Bean的实例
       // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("config.xml"));
        System.out.println("我是IT学习者创建的实例:"+context.getBean("random").toString());
    }
}
