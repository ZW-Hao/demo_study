package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServletSession")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        //先判断验证码是否正确
        HttpSession session = request.getSession();
        String check_code = (String)session.getAttribute("check_session");
        if (check_code!=null&& check_code.equalsIgnoreCase(checkcode)){//忽略大小写
                if ("张三".equals(username)&&"123".equals(password)){
                    //登录成功，显示登录成功页面
                    //存储用户信息，重定向到登陆成功页面
                    session.setAttribute("user",username);
                    response.sendRedirect(request.getContextPath()+"/success.jsp");

                }else{
                    //登录失败
                    //存储提示信息到request
                    request.getSession().setAttribute("password_error","用户名或密码错误");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
        }else{
            //验证码不一致，存储数据到request
            request.getSession().setAttribute("checkcode_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
    }
}
