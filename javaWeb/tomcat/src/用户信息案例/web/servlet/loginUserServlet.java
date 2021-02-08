package 用户信息案例.web.servlet;

import 用户信息案例.domain.Admin;
import 用户信息案例.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUserServlet")
public class loginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先进行验证码的校验

        //获取session中存储的验证码，将其和页面获得的验证码来比较
        String checkcode = (String)request.getSession().getAttribute("checkcode");

        //从页面获取验证码
        String verifycode = request.getParameter("verifycode");

        if (!verifycode.equalsIgnoreCase(checkcode)){
            //验证码校验失败
            request.setAttribute("error","验证码错误");
            request.getRequestDispatcher("/userDemo/login.jsp").forward(request,response);
            return;
        }

        //验证码校验通过，从表单中获取账号和密码，封装为对象
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        Admin admin=new Admin();
        admin.setAccount(account);
        admin.setPassword(password);
        UserServiceImpl userService=new UserServiceImpl();
        boolean flag = userService.login(admin);

        if (flag){
            //登录成功
            response.sendRedirect(request.getContextPath()+"/userDemo/index.jsp");
        }else{
            //登陆失败
            request.setAttribute("error","账号或密码错误");
            //response.sendRedirect(request.getContextPath()+"/userDemo/login.jsp");
            request.getRequestDispatcher("/userDemo/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
