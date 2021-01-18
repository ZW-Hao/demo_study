package com.Bzhan.JDBC.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/18
 * 描述：
 */
public class demoC3P0 {
    public static void main(String[] args) throws SQLException {
        DataSource ds=new ComboPooledDataSource();

        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
