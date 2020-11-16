package com.Bzhan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    模拟服务器，将需要的文件发送给客户端
    需要读取本地的文件
    再用网络流中的写操作

 */
public class demo_11_15_02 {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        Socket socket=server.accept();

        FileOutputStream  fos=new FileOutputStream("src\\serverupload\\b.txt");
        int len=0;


    }
}
