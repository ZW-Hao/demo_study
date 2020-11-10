package com.Bzhan;

import java.io.*;

/*
    字符编码和字符集
    字符编码和解码
    filereader可以读取默认编码格式的文件（UTF-8）

    outputstreamwriter : 将字符以指定的编码方式装换位字节,写到文件中

    使用步骤：
        创建outputstreamwriter对象，构造方法中传递字节输出流和指定的编码名称
        使用write（）方法将字符装换位字节存储在缓冲区中、
        使用flush（）方法将缓冲区中的内容写到文件中
        释放资源


    inputstreamreader: 使用指定的解码方式将字节转换为字符

    使用步骤：
        创建inputstreamreader对象，构造方法中传递字节输入流和编码方式
        reader方法
        释放资源
 */
public class demo_11_10_01 {
    public static void main(String[] args) throws IOException {
       write_utf_8();
       read_utf_8();

    }

    private static void read_utf_8() throws IOException {

        InputStreamReader isr=new InputStreamReader(new FileInputStream("src\\File\\f.txt"),"gbk");
        int len=0;
        while((len= isr.read())!=-1){
            System.out.println((char) len);
        }
        isr.close();
    }

    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("src\\File\\f.txt"),"gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
