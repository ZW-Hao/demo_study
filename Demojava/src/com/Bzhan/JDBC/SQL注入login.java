package com.Bzhan.JDBC;

import com.Bzhan.JDBC.Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/17
 * 描述：
 */
public class SQL注入login {
    public static void main(String[] args) {
        /**
         *@创建人 Hzw
         *@参数
         *@返回值
         *@描述
         */
        List<Users> list=new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入账号和密码：");

        String account=input.next();
        String password=input.next();
        //String sql="select * from users where username ='"+account+"' and userpassword = '"+password+"'";
        String sql="select * from users where username = ? and userpassword = ? ";
        //System.out.println(sql);
        try {
            //conn = DriverManager.getConnection("jdbc:mysql:///mywebodbc","root","123456");
            conn= JDBCUtils.getConnection();
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,account);
            stmt.setString(2,password);
            rs=stmt.executeQuery();

            //从前台得到用户账号和密码，list集合中的用户对比
           if(rs.next()){
               System.out.println("登录成功");
           }else{
               System.out.println("登录失败");
           }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.close(rs,stmt,conn);
        }

    }
}
