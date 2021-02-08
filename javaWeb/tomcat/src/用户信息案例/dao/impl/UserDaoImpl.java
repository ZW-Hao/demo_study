package 用户信息案例.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import 用户信息案例.dao.UserDao;
import 用户信息案例.domain.Admin;
import 用户信息案例.domain.User;
import 用户信息案例.utils.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用jdbc完成查询
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;

    }

    @Override
    public boolean addUser(User user) {

        String sql="insert into user VALUES (null,?,?,?,?,?,?)";
       /* String sql="INSERT INTO user VALUES ("+user.getId()+","+user.getName()
                +","+user.getGender()+","+user.getAge()+","+user.getAddress()
                +","+user.getQq() +","+user.getEmail()+")";*/
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

        return true;
    }

    @Override
    public boolean repeatName(String name) {
        //判断数据库中是否有和name相同的姓名
        String sql="select * from user where name = ?";

        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class),name);

        if (list.isEmpty()){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public boolean updateUser(User user,int id) {

        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender()
                        ,user.getAge(),user.getAddress(),user.getQq()
                        ,user.getEmail(),id);

        return true;




    }

    @Override
    public boolean login(Admin admin) {
        String sql="select * from admin where account=? and password=?";
        List<Admin> list = template.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class), admin.getAccount(), admin.getPassword());
        if (!list.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String sql="delete  from user where id=?";
        template.update(sql, id);
        return true;
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }


}











