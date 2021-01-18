package com.Bzhan.JDBC;

import com.Bzhan.JDBC.Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/17
 * 描述：登录案例的实现，键盘输入用户名和密码，对比数据库中的用户表
 */
public class loadin {
    public static void main(String[] args) {
        /**
         *@创建人 Hzw
         *@参数
         *@返回值
         *@描述
         */
        List<Users> list=new ArrayList<>();
        Connection conn = null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select * from users";
        try {
            //conn = DriverManager.getConnection("jdbc:mysql:///mywebodbc","root","123456");
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Users user=new Users(rs.getInt(1),rs.getInt(2));
                list.add(user);
            }
            //从前台得到用户账号和密码，list集合中的用户对比


            Scanner input=new Scanner(System.in);
            System.out.println("请输入账号和密码：");
            int account=input.nextInt();
            int password=input.nextInt();
            int i=0;
            for (i = 0; i < list.size(); i++) {
                if(account==list.get(i).getAccount()&&password==list.get(i).getPassword()){
                    System.out.println("登录成功");
                    break;
                }
            }
            if(i==list.size()){
                System.out.println("没有此用户！！！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.close(rs,stmt,conn);
        }

    }
}
