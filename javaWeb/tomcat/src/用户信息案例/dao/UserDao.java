package 用户信息案例.dao;

import 用户信息案例.domain.Admin;
import 用户信息案例.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public boolean addUser(User user);
    public boolean repeatName(String name);
    public  boolean updateUser(User user,int id);
    public boolean login(Admin admin);
    public boolean delete(int id);
    public User findUserById(int id);
}
