package com.Bzhan;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/*
    缓冲流 对基本的流的一种增强
    bufferedoutputstream
        使用步骤：
            创建fileoutputstream对象
            创建bufferedoutputstream对象，提高fileoutputstream对象的效率
            使用bufferedoutputstream对象中的write（）把数据写入缓冲区中
            使用flush（）将缓冲区中的数据写入文件中
            释放资源
    bufferedinputstream
    bufferedreader
    bufferedwriter

 */
public class demo_11_09_01 {
    public static void main(String[] args) throws IOException {
        /*FileOutputStream fos=new FileOutputStream("src\\File\\e.txt");
        BufferedOutputStream bfos=new BufferedOutputStream(fos);
        bfos.write("文件".getBytes());
        bfos.flush();
        bfos.close();*/

        /*FileInputStream fis=new FileInputStream("src\\File\\e.txt");
        BufferedInputStream bfis=new BufferedInputStream(fis);
        int len=0;
        while((len=bfis.read())!=-1){
            System.out.println(len);
        }
        bfis.close();
        */

        FileReader fr=new FileReader("src\\File\\e.txt");
        BufferedReader bfr=new BufferedReader(fr);

        char[] cs=new char[1024];

        /*String str;
        while((str=bfr.readLine())!=null){
            System.out.println(str);
        }*/

        String str;
        String stradd="";
        while(true){
            if((str=bfr.readLine())!=null){
                stradd=stradd+str;
            }else{
                break;
            }
        }
        System.out.println(stradd);


        /*while((len=bfr.read(cs))!=-1){

            *//*str=new String(cs,0,len);*//*
        }*/




        // TODO: 2020/11/9 去掉从文件中读取的字符串中的换行符

        /*char[] c=new char[1024];
        c=str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(i+"  "+c[i]);
        }*/

    }
}
