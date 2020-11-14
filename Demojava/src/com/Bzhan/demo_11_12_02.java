package com.Bzhan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/*
    通信客户端代码实现
        向服务器发送连接请求，给服务器发送请求，读取服务器回写的数据
        表示客户端的类 java.net.socket 实现客户端套接字（两台机器间通信的节点）
        套接字是包含IP地址和端口号的网络单位
    构造方法：
        socket（string host，int port）创建一个套接字并将其连接到指定的主机上的指定端口号
        参数：
            string host 服务器IP地址
            int port 服务器端口号

     实现步骤
        创建一个客户端对象socket，构造方法绑定服务器的IP地址和端口号
        使用socket中的getoutputstream()获取网络字节输出流outputstream对象
        使用网络字节输出流outputstream中的write（）方法给服务器发送数据
        使用socket中的方法getinputstream()方法获取网络字节输入流inputstream对象
        使用网络字节输入流inputstream对象中的方法read（）读取服务器回写的数据
        释放资源


        客户端和服务器端进行交互必须使用socket类中的方法，不能使用自己创建的对象
        创建客户端socket对象的时候，会请求和服务器经过3次握手建立连接通路，如果服务器没有启动会抛出异常
 */
public class demo_11_12_02 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);

        OutputStream os=socket.getOutputStream();
        //向服务器端传递数据
        //向服务器传递
        byte[] image=new byte[1024];
        FileInputStream frone=new FileInputStream("src\\File\\a.txt");


        os.write("你好，请接受数据".getBytes());

        InputStream is=socket.getInputStream();
        byte[] b=new byte[1024];
        int len=is.read(b);
        System.out.println(new String(b,0,len));
        socket.close();
        ArrayList a=new ArrayList();
    }
}
