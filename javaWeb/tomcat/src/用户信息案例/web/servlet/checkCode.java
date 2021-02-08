package 用户信息案例.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class checkCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int width=100;
        int height=50;
        //创建对象，在内存中代表图片
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //美化图片
        Graphics g = image.getGraphics();//获取画笔对象
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);

        Random r=new Random();
        //随机生成坐标点
        g.setColor(Color.green);
        for (int i = 0; i < 5; i++) {
            int x1=r.nextInt(width);
            int x2=r.nextInt(width);
            int y1=r.nextInt(height);
            int y2=r.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }


        String str="ABCDEFGHIJabcdefghij0123456789";
        g.setColor(Color.blue);
        int index;
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=4 ; i++) {
            index = r.nextInt(str.length());
            char c = str.charAt(index);
            sb.append(c);
            g.drawString(c+"",20*i,25);
        }
        String s = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkcode",s);


        //输出到页面上显示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}





