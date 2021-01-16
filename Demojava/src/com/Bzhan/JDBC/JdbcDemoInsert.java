package com.Bzhan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemoInsert {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        try{
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql语句
            String sql="insert into users values(1234,1234)";

             conn= DriverManager.getConnection("jdbc:mysql:///mywebodbc", "root", "123456");

             stmt = conn.createStatement();

            int count=stmt.executeUpdate(sql);

            if (count>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            //避免空指针异常
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
