import com.tom.bean_life_cycle.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tom on 2016/5/5.
 */
public class BeanLifeCircleTest extends BaseTest{
    @Test
    public void test() {
        System.out.println("现在开始初始化容器");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-life-cycle.xml");
        System.out.println("容器初始化成功");

        //得到Preson，并使用
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
    }
}
