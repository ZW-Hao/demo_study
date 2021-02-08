package 用户信息案例.web.servlet;

import 用户信息案例.domain.User;
import 用户信息案例.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用userService完成查询
        UserServiceImpl service=new UserServiceImpl();
        List<User> users = service.findAll();

        //将list存入域中
        request.setAttribute("users",users);
        //转发到jsp中
        request.getRequestDispatcher("/userDemo/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
