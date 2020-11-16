package com.Bzhan;

import java.io.*;

//字符流  读取中文
//字符输入流 reader类
/*
    java.io.FileReader  文件字符输入流 将文件中的数据以字符的方式读入内存中

 */
public class demo_11_08_01 {
    public static void main(String[] args) throws IOException {
/*        FileInputStream fis=new FileInputStream("src\\File\\c.txt");
        int len=0;
        while((len=fis.read())!=-1){
            System.out.println(len);
        }
        fis.close();*/
        //FileReader fr=new FileReader("src\\File\\c.txt");

/*        int len =0;
        while((len=fr.read())!=-1){
            System.out.println((char)len);
        }*/

        /*int len=0;//记录有效字符的个数
        char[] cs=new char[1024];
        while((len=fr.read(cs))!=-1){
            System.out.println(len);
            System.out.println(new String(cs,0,len));
        }
        fr.close();*/


        /*
            文件字符输出流 Java.io.FileWrite

         */
        FileWriter fw=new FileWriter("src\\File\\c.txt",true);
        int len=0;
        String a="a  03 3 / ;] qp ";
        fw.write(a);
        fw.flush();//刷新数据，将数据写入文件中
        fw.close();
    }
}
