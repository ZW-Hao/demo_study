package Servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class demo {
    public static void main(String[] args) {
        Properties properties=new Properties();
        try {
            properties.load(new FileReader("D:\\Git\\cangku\\demo_study\\javaWeb\\tomcat\\src\\druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            JdbcTemplate js=new JdbcTemplate(ds);
            String sql="delete from users where username='zhangsan' ";
            js.update(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
