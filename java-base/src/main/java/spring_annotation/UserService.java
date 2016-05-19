package spring_annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: TOM
 * Date: 2016/5/19
 * email: beauty9235@gmail.com
 * Time: 10:42
 */

public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    // 字段上的注解
    @TomResourceAnnotation
    public UserDao userDao1;

    // 字段上的注解,配置name属性
    @TomResourceAnnotation(name = "userDao")
    public UserDao userDao2;

    private UserDao userDao3;
    //set方法上的注解
     @TomResourceAnnotation
    public void setUserDao3(UserDao userDao3) {
        this.userDao3 = userDao3;
    }
    private UserDao userDao4;
    //set方法上的注解，带有name属性
    @TomResourceAnnotation(name = "userDao")
    public void setUserDao4(UserDao userDao4) {
        this.userDao4 = userDao4;
    }

    public User getUser1() {
        User user = userDao1.queryUser();
        return user;
    }
    public User getUser2() {
        User user = userDao2.queryUser();
        return user;
    }
    public User getUser3() {
        User user = userDao3.queryUser();
        return user;
    }
    public User getUser4() {
        User user = userDao4.queryUser();
        return user;
    }
}
