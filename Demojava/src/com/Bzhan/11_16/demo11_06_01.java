package com.Bzhan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class demo11_06_01 {
//    io操作  Java.io 包
//    字节流，读取任意的文件
//    字节输出流  outputstream抽象类  字节输出流的超类，定义共性方法
//    fileoutputstream 文件字节输出流，将内存中的数据写入硬盘文件中
//    构造方法实现创建一个只想文件的字节输出流
    /*
    字节输出流的使用步骤：
            创建fileoutputstream对象，构造方法中写入输入数据的目的地
            调用方法write写入文件
            使用完毕后要释放资源
     */
    /*
        一次写入多个字节

     */
    public static void main(String[] args) throws IOException {
        FileOutputStream file=new FileOutputStream("D:\\Git\\cangku\\demo_study\\Demojava\\src\\File\\a.txt",true);
        file.write(49);//将asc码为97的字母写入文件
        file.write(48);//将asc码为97的字母写入文件
        file.write(48);//将asc码为97的字母写入文件

//        //write(byte[] b) 传入一个字节数组 实现一次写入多个字节
//        byte[] b={65,66,67,68,69};
//        file.write(b);
//        file.close();
        //将一个字符串转化为字节数组
//        byte[] b2="你好".getBytes();
//        file.write(b2);
//        file.close();

        for (int i = 0; i < 10; i++) {
            file.write("你好\n".getBytes());
        }
    }
}
