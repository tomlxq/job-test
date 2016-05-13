import com.tom.entities.User;
import groovy.util.GroovyTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by tom on 2016/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jdbc.xml" })
//@ContextConfiguration(classes=[AppConfig.class])
public class BaseGroovyTest extends GroovyTestCase
{

    @Autowired
     JdbcTemplate jdbcTemplate;

    @Test
    public void findAll() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS `user`");
        jdbcTemplate.execute("create table user (id int(10) unsigned NOT NULL AUTO_INCREMENT,username varchar(40),password varchar(40),sex int(1), PRIMARY KEY (`id`))");
        User user=new User("tom","1234",1);
        jdbcTemplate.update("insert into user(username,password,sex) values(?,?,?)",
                new Object[]{user.getUsername(),user.getPassword(),user.getSex()});
    }
}
