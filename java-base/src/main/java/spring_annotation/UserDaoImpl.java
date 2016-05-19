package spring_annotation;

/**
 * User: TOM
 * Date: 2016/5/19
 * email: beauty9235@gmail.com
 * Time: 10:41
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User queryUser() {
        //假設我們從持久層獲取了對象
        return new User("tomLuo", "789", "beauty9235@gmail.com");
    }
}
