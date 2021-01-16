package com.Bzhan.JDBC;

//import com.mysql.jdbc.Connection;

import java.sql.*;

public class JDBCcreate {

    public static void main(String[] args) throws Exception {
        Connection conn= DriverManager.getConnection("jdbc:mysql:///mywebodbc","root","123456");
        //String sql="create table product (productid int , productname varchar(20))";
        String sql  = "insert into productTable(\n" +
                "    productId ,\n" +
                "    productName ,\n" +
                "    productInformation ,\n" +
                "    sortId ,\n" +
                "    price ,\n" +
                "    supplierId \n" +
                ")\n" +
                "values(1,'mate40','new 5Gphone',1,6999,1)";
        Statement state=conn.createStatement();
        int count=0;
        try{
            count= state.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(count);
        state.close();
        conn.close();

    }
}
