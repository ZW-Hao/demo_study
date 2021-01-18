package com.Bzhan.JDBC.Druid;

import com.Bzhan.JDBC.Utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/18
 * 描述：
 */
public class demoDruid {
    public static void main(String[] args) throws Exception {
        /*Properties pro=new Properties();

        InputStream is = demoDruid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);


        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);*/

        Properties pro=new Properties();
        pro.load(new FileReader("D:\\Git\\cangku\\demo_study\\Demojava\\src\\druid.properties"));

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();

        String sql="insert into users values('zhangsan',123456)";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        int count = pstmt.executeUpdate();
        System.out.println(count);

        JDBCUtils.close(pstmt,conn);


    }
}
