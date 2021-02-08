package 用户信息案例.web.servlet;

import 用户信息案例.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id值
        String id = request.getParameter("id");
        //调用函数
        UserServiceImpl userService=new UserServiceImpl();
        userService.delete( id);
        //重定向到list表
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
