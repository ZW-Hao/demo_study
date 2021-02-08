package 用户信息案例.service;

import 用户信息案例.domain.Admin;
import 用户信息案例.domain.User;

import java.util.List;
//用户管理的业务窗口

public interface UserService {
    //查询所有用户信息
    public List<User> findAll();
    public boolean addUser(User user);
    public boolean updateUser(User user,String id);
    public boolean login(Admin admin);
    public boolean delete(String id);
    public User findUserById(String id);
}
