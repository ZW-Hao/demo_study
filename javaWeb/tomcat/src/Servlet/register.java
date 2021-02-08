package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*BufferedReader bf = request.getReader();
        String line=null;
        while((line=bf.readLine())!=null){
            System.out.println("post");
            System.out.println(line);
        }*/
        //设置流编码方式
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        System.out.println("post");
        System.out.println(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);
    }
}
