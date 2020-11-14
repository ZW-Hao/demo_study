package com.Bzhan;

import java.io.*;
import java.net.Socket;

/*
    文件上传案例
    客户端读取本地文件，把文件上传到服务器，并将文件保存到服务器硬盘上
        客户端使用本地的字节输入流，读取上传的文件
        客户端使用网络字节输出流将读取到的文件上传到服务器
        服务器使用网络字节输入流，读取客户端上传的文件
        服务器使用本地字节输出流，把读取到的文件，保存到服务器的硬盘上
        使用网络字节输出流，给客户端回写上传成功的信息
        释放资源


    注意事项：
        客户端和服务器在本地硬盘进行读写，需要使用自己创建的字节流对象（本地流）
        客户端和服务器之间进行读写，必须使用socket中提供的字节流对象（网络流）


        文件上传的客户端
        实现步骤：
            创建一个本地的字节输入流Fileinputstream对象，构造方法中绑定数据源
            创建一个客户端socket对象，构造方法中绑定服务器的IP地址和端口号
            使用socket中的方法getoutputstream获取网络字节输出流outputstream对象
            使用本地字节输入流fileinputstream对象中的方法read读取本地文件
            使用网络字节输出流outputstream对象中的write（）方法，将读取到的文件上传到服务器
            使用socket中的getinputstream，获取网络字节输入流inputstream对象
            使用网络字节输入流inputstream对象中的方法read读取服务器传回的数据
            释放资源
 */
public class demo_11_12_04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("src\\File\\b.txt");

        Socket socket=new Socket("127.0.0.1",8888);

        OutputStream os=socket.getOutputStream();

        int len=0;
        byte[] b=new byte[1024];
        while((len= fis.read(b))!=-1){
            os.write(b,0,len);
        }

        socket.shutdownOutput();//关闭写流，防止服务器接收不到-1，使得程序进入阻塞状态

        InputStream is=socket.getInputStream();
        while((len=is.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }

        fis.close();
        socket.close();
    }

}
