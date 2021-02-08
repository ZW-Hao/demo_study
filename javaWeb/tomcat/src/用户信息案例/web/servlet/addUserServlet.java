package 用户信息案例.web.servlet;

import org.springframework.beans.BeanUtils;
import 用户信息案例.domain.User;
import 用户信息案例.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //Map<String, String[]> map = request.getParameterMap();

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        User user=new User();

        user.setId(4);
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setAddress(address);
        user.setQq(qq);
        user.setEmail(email);

        UserServiceImpl service=new UserServiceImpl();

        boolean b = service.addUser(user);//需要接受页面传入的参数

        if (b){
            //重定向到list.jsp
            response.sendRedirect(request.getContextPath()+"/userListServlet");

        }else{
            //提示错误，在数据库中有重复的姓名的时候会添加失败
            response.sendRedirect(request.getContextPath()+"/userListServlet");
            //request.setAttribute("flag",false);//设置错误标志
            // TODO: 2021/2/6 添加数据失败后需要在添加页面提示信息


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
