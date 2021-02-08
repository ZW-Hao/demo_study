package Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet{
    //初始化方法，只在创建时执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {

        return null;
    }
    //每一次servlet被访问时执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    //在服务器正常关闭时执行一次
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
