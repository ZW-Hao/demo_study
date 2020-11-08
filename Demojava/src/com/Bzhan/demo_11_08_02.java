package com.Bzhan;

import java.io.FileWriter;
import java.io.IOException;

/*
    try catch finally 处理异常代码
    try{
        可能会产生异常的代码
    }catch(异常类变量 变量名){
        异常处理的代码
    }finally{
        一定会执行的代码
        资源释放
    }
 */
public class demo_11_08_02 {
    public static void main(String[] args) {
        /*FileWriter fw=null;
        try{
            fw=new FileWriter("srcd\\File\\d.txt",true);
            for (int i = 0; i < 5; i++) {
                fw.write("hello"+i+"\r\n");
            }

        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }*/

        try(FileWriter fw=new FileWriter("srcd\\File\\d.txt",true);){
            for (int i = 0; i < 5; i++) {
                fw.write("hello"+i+"\r\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
