import com.tom.entities.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * Created by tom on 2016/5/4.
 */
public class TestDb extends BaseTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 创建表
     */
    public void createT(){ //tb_test1
        jdbcTemplate.execute("DROP TABLE IF EXISTS `user`");
        jdbcTemplate.execute("create table user (id int(10) unsigned NOT NULL AUTO_INCREMENT,username varchar(40),password varchar(40),sex int(1), PRIMARY KEY (`id`))");
    }
//jdbcTemplate.update适合于insert 、update和delete操作；
    /**
     * 第一个参数为执行sql
     * 第二个参数为参数数据
     */
    public void save(User user) {
        logger.debug("{}",user);
        //Assert.isNull(user, "user is not null");

        jdbcTemplate.update("insert into user(username,password,sex) values(?,?,?)",
                new Object[]{user.getUsername(),user.getPassword(),user.getSex()});
    }
    @Test
    public void test(){
        createT();
        User user=new User("tom","1234",1);
        save(user);
    }

}
