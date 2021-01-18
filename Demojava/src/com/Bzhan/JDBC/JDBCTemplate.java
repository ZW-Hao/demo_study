package com.Bzhan.JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/18
 * 描述：
 */
public class JDBCTemplate {
    public static void main(String[] args) {
        Properties pro=new Properties();
        try {
            pro.load(new FileReader("D:\\Git\\cangku\\demo_study\\Demojava\\src\\druid.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            JdbcTemplate jt=new JdbcTemplate(ds);
            String sql="delete from users where username='zhangsan'";
            jt.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
