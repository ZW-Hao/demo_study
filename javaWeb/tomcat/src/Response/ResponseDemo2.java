package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//设置编码
        response.setCharacterEncoding("GBK");
        //告诉浏览器发送的消息体数据的编码方式
        response.setHeader("content-type","text/html;charset=utf-8");
        */
        //简单形式设置编码
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter pw = response.getWriter();
        pw.write("<h1>你好 response</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}





