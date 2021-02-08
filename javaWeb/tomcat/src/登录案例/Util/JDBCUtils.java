package 登录案例.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//JDBC工具类，使用durid连接池
public class JDBCUtils {
    private static DataSource  ds;

    static {
        //加载配置文件
        Properties pro=new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化连接池对象
        try {
            ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取连接connection对象
    public static Connection getCOnnection() throws SQLException {
        return ds.getConnection();
    }
}

















