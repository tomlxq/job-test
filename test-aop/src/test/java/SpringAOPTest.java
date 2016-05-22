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
    @Qualifier("serviceProxy")
    private OrderService service;

    @Test
    public void testOrder() {
        service.save();
        service.delete(88);
    }
}