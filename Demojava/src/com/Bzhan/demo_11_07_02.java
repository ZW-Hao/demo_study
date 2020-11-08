package com.Bzhan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件复制
        数据源：a.txt
        目的地：b.txt
    步骤
        创建字节输入流和字节输出流对象
        使用read（）方法读取文件
        使用write（）方法写入目的地文件
 */
public class demo_11_07_02 {
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("src\\File\\1.jpg");
        FileOutputStream fos=new FileOutputStream("src\\File\\2.jpg");
 /*       //一次读取一个字节
        int len=0;
        while((len=fis.read())!=-1){
            fos.write(len);
        }*/

        byte[] b=new byte[1024];

        int len=0;
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }

        //先关闭写流
        fos.close();
        fis.close();
        long e=System.currentTimeMillis();
        System.out.println("复制文件共耗时："+(e-s)+"毫秒");
    }
}
