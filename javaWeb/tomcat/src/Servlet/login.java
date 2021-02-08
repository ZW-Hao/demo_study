package Servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        //连接数据库，从数据库中得到user表
        Properties properties=new Properties();
        try {
            properties.load(new FileReader("D:\\Git\\cangku\\demo_study\\javaWeb\\tomcat\\src\\druid.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            JdbcTemplate js=new JdbcTemplate(ds);
            String sql="delete from users where username='zhanghan' ";
            js.update(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
