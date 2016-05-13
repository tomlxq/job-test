import com.tom.jdbc_hibernate.HibernateConfiguration;
import com.tom.jdbc_hibernate.Person;
import com.tom.jdbc_hibernate.PersonDao;
import com.tom.jdbc_hibernate.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by tom on 2016/5/5.
 * http://www.yiibai.com/spring_mvc/spring-4-mvc-and-hibernate4-integration-example.html
 */
@ContextConfiguration(classes = {HibernateConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestHibernate {
    Logger logger = LoggerFactory.getLogger(TestHibernate.class);
    @Autowired
    PersonService personService;

    @Test
    public void testPerson() {
        personService.savePerson(new Person("tom", 21, new Date()));
        personService.savePerson(new Person("tom1", 33, new Date()));
        personService.savePerson(new Person("tom2", 44, new Date()));
        personService.savePerson(new Person("tom3", 55, new Date()));
        personService.savePerson(new Person("tom4", 71, new Date()));
        logger.debug("{}", personService.findById(1l));
        logger.debug("{}", personService.findAllPersons());
        logger.debug("{}", personService.findPersonByName("tom"));
        personService.deletePersonById(1l);
    }

}
