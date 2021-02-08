package 文件下载;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");//获取文件名称
        System.out.println(filename);
        //使用字节输入流加载进入内存
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        //设置response响应头
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        response.setHeader("content-disposition","attachment;filename="+filename);

        //将输入流的数据写出到输出流中
        ServletOutputStream os = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while((len=fis.read(buff))!=-1){
            os.write(buff,0,len);
        }

        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
