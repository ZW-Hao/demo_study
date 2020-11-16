package com.Bzhan;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class demo_11_12_01 {
    public static void main(String[] args) throws IOException {
        /*FileReader fr=new FileReader("src\\File\\lesson1022.sql");
        int len=0;
        char[] c=new char[1024];
        while((len= fr.read(c))!=-1){
            System.out.println(c);
        }
        fr.close();*/


        /*FileInputStream fis=new FileInputStream("src\\File\\lesson1022.sql");
        int len=0;
        byte[] b=new byte[1024];
        while((len= fis.read(b))!=-1){
            System.out.println(b);
        }*/

        InputStreamReader isr=new InputStreamReader(new FileInputStream("src\\File\\lesson1022.sql"),"gbk");
        int len=0;
        char[] c=new char[1024];

        while((len= isr.read(c))!=-1){
            System.out.println(c);
        }
    }
}
