package com.Bzhan;

import java.io.*;

public class demo_11_09_02 {
    /*
        使用缓冲流复制数据时间测试
        时间减少
     */
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();

        FileOutputStream fos=new FileOutputStream("src\\File\\1.jpg");
        FileInputStream fis=new FileInputStream("src\\File\\2.jpg");
        BufferedInputStream bfis=new BufferedInputStream(fis);
        BufferedOutputStream bfos=new BufferedOutputStream(fos);
        int len=0;
        byte[] b=new byte[1024];
        while((len=bfis.read(b))!=-1){
            bfos.write(b,0,len);
        }
        bfos.close();
        bfis.close();

        long e=System.currentTimeMillis();

        System.out.println("耗时："+(e-s));
    }
}
