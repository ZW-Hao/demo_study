package com.Bzhan.JDBC;


import java.sql.*;
/**
 * 测试连接数据库是否成功
 * @author 明
 *
 */
public class JdbcTest{
    public static void main(String args[]) throws SQLException {
        //1. 导入驱动jar包
        //2.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebodbc", "root", "123456");
        //Connection conn = DriverManager.getConnection("jdbc:mysql:///mywebodbc", "root", "123456");
        //4.定义sql语句
        String sql = "update users set userpassword = 123456 where username = 123456  ";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);//执行成功返回1，失败返回0
        //8.释放资源
        stmt.close();
        conn.close();
    }
}

