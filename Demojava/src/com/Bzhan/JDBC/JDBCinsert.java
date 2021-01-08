package com.Bzhan.JDBC;


import java.sql.*;

public class JDBCinsert {

    public static void main(String[] args) throws Exception {
        //注册驱动可以不写
         Class.forName("com.mysql.jdbc.Driver");

        Connection conn= DriverManager.getConnection("jdbc:mysql:///mywebodbc","root","123456");
        String sql="insert into users values(1234,1234)";
//        Statement state=conn.createStatement();
        Statement state=conn.createStatement();
        int count=0;
        try{
            count=state.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(count);
        state.close();
        conn.close();


//        Statement stmt = null;
//        Connection conn = null;
//        try {
//            //1. 注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2. 定义sql
//            String sql = "insert into users values(123,3000)";
//            //3.获取Connection对象
//            conn = DriverManager.getConnection("jdbc:mysql:///mywebodbc", "root", "123456");
//            //4.获取执行sql的对象 Statement
//            stmt = conn.createStatement();
//            //5.执行sql
//            int count = stmt.executeUpdate(sql);//影响的行数
//            //6.处理结果
//            System.out.println(count);
//            if(count > 0){
//                System.out.println("添加成功！");
//            }else{
//                System.out.println("添加失败！");
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            //stmt.close();
//            //7. 释放资源
//            //避免空指针异常
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }







    }

}
