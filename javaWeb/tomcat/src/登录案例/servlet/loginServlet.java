package 登录案例.servlet;

import 登录案例.User;
import 登录案例.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao dao = new userDao();
        User loginUser = dao.login(user);

        if (loginUser==null){
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            //登录成功
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
