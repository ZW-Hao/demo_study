package com.Bzhan;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

//字节输入流
//inputstream 超类
//fileinputstream 文件读取
//构造方法
//fileinputstream(文件路径)
/*
    读取数据的原理：
        Java程序->jvm->os->os读取文件
    使用步骤：
        创建字节输入流的对象
        使用方法read（）
        释放资源close（）
 */
public class demo_11_07_01 {
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("src\\File\\a.txt");
        //读取文件中的一个字节
        int len;

//        while(true){
//
//            len=fis.read();
//            if(len!=-1){
//                System.out.println(len);
//            }else{
//                break;
//            }
//
//        }
        //读取一个字节后会将指针移到下一个字节的位置，需要用一个变量保存此时读取的字节
//        while((len=fis.read())!=-1){
//            System.out.println(len);
//        }
//
        byte[] b=new byte[5];
        len=fis.read(b);
        System.out.println(len);
        System.out.println(Arrays.toString(b));
        System.out.println(new String(b));
        fis.close();
        long e=System.currentTimeMillis();
        System.out.println("复制文件共耗时："+(e-s)+"毫秒");

    }

}
