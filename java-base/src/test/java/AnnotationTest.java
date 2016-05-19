import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring_annotation.ClassPathXMLApplicationContext;
import spring_annotation.UserService;
/**
 * User: TOM
 * Date: 2016/5/19
 * email: beauty9235@gmail.com
 * Time: 11:26
 */

public class AnnotationTest {
    Logger logger = LoggerFactory.getLogger(UserService.class);
   static UserService userService;
    @BeforeClass
    public static void init() {
        ClassPathXMLApplicationContext path = new ClassPathXMLApplicationContext("annotation.xml");
         userService =(UserService)path.getBean("userService");
    }
    @Test
    public void findUsers() {
        logger.debug("{}",userService.getUser1());
        logger.debug("{}",userService.getUser2());
        logger.debug("{}",userService.getUser3());
        logger.debug("{}",userService.getUser4());
    }


}