package 用户信息案例.web.servlet;

import 用户信息案例.domain.User;
import 用户信息案例.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查找对应的用户信息
        String id = request.getParameter("id");
        //查找用户信息
        UserServiceImpl service=new UserServiceImpl();
        User user=service.findUserById(id);
        //将user对象存入request域中，转发
        request.setAttribute("user",user);
        request.getRequestDispatcher("/userDemo/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
