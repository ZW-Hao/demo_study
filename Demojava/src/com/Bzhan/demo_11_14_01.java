package com.Bzhan;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*

        模拟bs服务器实现浏览器和后台进行交互
 */
public class demo_11_14_01 {
    public static void main(String[] args) throws IOException {
        //创建一个bs服务器serversocket服务器和系统指定的端口号
//        ServerSocket server=new ServerSocket(8080);
        ServerSocket server = new ServerSocket(8080);
        //获取到网络请求客户端对象，即浏览器

//        Socket socket=server.accept();
//
//        InputStream is=socket.getInputStream();
        Socket socket = server.accept();
        //使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        byte[] b=new byte[1024];
        int len=0;
        while((len=is.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
    }
}
