package com.Bzhan.JDBC;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DemoJdbcSelect djs=new DemoJdbcSelect();
        List<Users> users = djs.findAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("用户名："+users.get(i).getAccount()+"密码："+users.get(i).getPassword());
        }

    }
}
