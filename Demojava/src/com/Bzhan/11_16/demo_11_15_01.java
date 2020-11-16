package com.Bzhan;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/*
    模拟客户端从服务器下载文件
    实现步骤：
        需要遍历服务器上的文件，寻找到自己需要的文件
        使用socket中的read（）方法读取服务器上的文件
        使用本地流中的方法write（）方法将文件写到客户端本地文件夹
        在用本地流中的方法read（）将下载好的文件读取出来
 */
public class demo_11_15_01 {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);

        InputStream is=socket.getInputStream();
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){

        }

    }

}
