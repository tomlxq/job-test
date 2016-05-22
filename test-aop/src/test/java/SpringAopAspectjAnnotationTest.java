import com.tom.aop.spring.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tom on 2016/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_aop_aspectj_annotation.xml")
public class SpringAopAspectjAnnotationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testOrder()  {
        orderService.save();
        orderService.delete(88);
    }
}