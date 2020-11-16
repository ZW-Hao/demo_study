package com.Bzhan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    tcp通信的服务器端：
        Java.net.serversocket
    构造方法
       serversocket（int port）
       创建绑定到指定端口的服务器套接字
    服务器必须知道是哪个客户端发送的请求，可以使用accept（）获取到请求客户端对象的socket

    服务器实现步骤：
        创建服务器serversocket对象和系统要指定的端口号
        使用serversocket方法中的accept（）获取请求客户端的socket
        使用socket对象中的方法getinputstream方法获取网络字节输入流inputstream对象
        使用网络字节输入流inputstream中的read（）方法读取客户端发送的数据
        使用scoket对象中的getoutputstream（）方法获取网络字节输出流outputstream对象
        使用outputstream对象中的write（）方法给客户端回数据
        释放资源

 */
public class demo_11_12_03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);

        Socket socket=server.accept();
        InputStream is=socket.getInputStream();
        byte[] b=new byte[1024];
        int len=is.read(b);
        System.out.println(new String(b,0,len));
        OutputStream os = socket.getOutputStream();
        os.write("收到,谢谢".getBytes());
        socket.close();
        server.close();

    }
}
