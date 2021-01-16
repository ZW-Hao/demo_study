package com.Bzhan.JDBC;

import java.sql.*;

public class JdbcSelectDemo {
    public static void main(String[] args) {
        //结果集，存储查询结果，游标
        Statement stmt=null;
        Connection conn=null;
        ResultSet resultset=null;
        try{
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql语句
            String sql="select * from users";

            conn= DriverManager.getConnection("jdbc:mysql:///mywebodbc", "root", "123456");

            stmt = conn.createStatement();
            //查询数据处理
            resultset = stmt.executeQuery(sql);

            //游标向下移动
            while(resultset.next()){
                int anInt = resultset.getInt(1);
                int anInt1 = resultset.getInt(2);
                //打印数据
                System.out.println("用户名："+anInt+"密码："+anInt1);
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
            if (resultset!=null){
                try {
                    resultset.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
