package 用户信息案例.service.impl;

import 用户信息案例.dao.UserDao;
import 用户信息案例.dao.impl.UserDaoImpl;
import 用户信息案例.domain.Admin;
import 用户信息案例.domain.User;
import 用户信息案例.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao来完成查询
        return dao.findAll();

    }

    @Override
    public boolean addUser(User user) {
        if (dao.repeatName(user.getName())){
            return dao.addUser(user);
        }else{
            return false;
        }
        /*return dao.addUser(user);*/
    }

    @Override
    public boolean updateUser(User user,String id) {
        int id_int = Integer.parseInt(id);
        return dao.updateUser(user,id_int);


    }

    @Override
    public boolean login(Admin admin) {
     return dao.login(admin);
    }

    @Override
    public boolean delete(String id) {
        //将id值转化为int类型，调用dao类删除方法
        int intid = Integer.parseInt(id);
        dao.delete(intid);
        return false;
    }

    @Override
    public User findUserById(String id) {
        //调用dao中的方法查询用户信息

        return dao.findUserById(Integer.parseInt(id));
    }
}











