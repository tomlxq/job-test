import com.tom.jdbc_hibernate.HibernateConfiguration;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by tom on 2016/5/4.
 */
@ContextConfiguration(locations = { "classpath:/jdbc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    /**
     *要指明唯一的数据源，如果只有一个就不用指明了。
     */
    @Override
    @Resource(name = "druid")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }


}