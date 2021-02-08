package 登录案例.test;

import org.junit.Test;
import 登录案例.User;
import 登录案例.dao.userDao;

public class userDaoTest {
    @Test
    public void testLogin(){
        User user=new User();
        user.setUsername("123456");
        user.setPassword("123456");
        userDao dao=new userDao();
        dao.login(user);
        System.out.println(user);






    }
}
