package com.Bzhan.JDBC;
import java.sql.*;
public class JDBCselect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///mywebodbc", "root", "123456");
            //3.定义sql
            String sql  = "select * from users";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据

            String name1 = rs.getString("username");
            String password1 = rs.getString("userpassword");


            System.out.println( name1 + "---" + password1);


            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            String name2 = rs.getString("username");
            String password2 = rs.getString("userpassword");


            System.out.println( name2 + "---" + password2);

            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            String name3 = rs.getString("username");
            String password3 = rs.getString("userpassword");


            System.out.println( name3 + "---" + password3);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源

            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
