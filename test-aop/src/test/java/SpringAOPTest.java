import com.tom.aop.spring.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tom on 2016/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_aop.xml")
public class SpringAOPTest {

    @Autowired
    /**
     * 这种方式的缺陷在于每个Target都必须手动指定ProxyFactoryBean对其代理(不能批量指定),
     * 而且这种方式会在Spring容器中存在两份Target对象(代理前/代理后),浪费资源,且容易出错(比如没有指定@Qualifier).
      */
    //必须指定使用代理对象名称, 否则不予代理
    @Qualifier("serviceProxy")
    private OrderService service;

    @Test
    public void client() {
        service.save();
        service.delete(88);
    }
}