package 登录案例.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import 登录案例.User;
import 登录案例.Util.JDBCUtils;

//操作数据库中user表的类
public class userDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    //登录方法
    public User login(User loginUser){


        try {
            String sql="select * from users where username=? and userpassword=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class)
                    , loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

















}
