package com.Bzhan.JDBC;



import java.sql.*;

public class JDBCdelete {
    public static void main(String[] args) throws Exception {
       // Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql:///mywebodbc","root","123456");
        String sql="delete from users where username=1234";
        Statement state=conn.createStatement();
        int count =state.executeUpdate(sql);
        System.out.println(count);
        state.close();
        conn.close();
    }
}
