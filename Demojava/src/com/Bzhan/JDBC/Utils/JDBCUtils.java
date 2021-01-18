package com.Bzhan.JDBC.Utils;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/17
 * 描述：JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    static {
        Properties pro=new Properties();
        try {
            pro.load(new FileReader("D:\\Git\\cangku\\demo_study\\Demojava\\src\\com\\Bzhan\\JDBC\\JDBCproject.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
        }catch(NullPointerException e){
            e.printStackTrace();
        }



    }
   /**
    *@创建人 Hzw
    *@参数
    *@返回值
    *@描述 获取连接,不传递参数，保证工具类的通用性，通过配置文件解决
    */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     *@创建人 Hzw
     *@参数
     *@返回值
     *@描述  释放资源
     */
    public static void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement stmt, Connection conn){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    
}
