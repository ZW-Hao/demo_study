package com.Bzhan;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    打印流
        java.io.printstream  为其他的输入流添加了新功能，使其能够方便的打印各种数据表示形式
        特点
            只负责数据的输出，不管数据的读取
            永远不会抛出io异常
        方法
            print（）
            println（）

        构造方法
            printstream(File file)输出的目的地是一个文件
            printstream(outputstream out) 输出的目的地是一个字节输出流
            printstream(string filename)输出的目的地是一个文件路径
 */
public class demo_11_11_03 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("控制台打印");


        //改变打印的文件地址
        PrintStream ps=new PrintStream("src\\File\\m.txt");
        System.setOut(ps);
        System.out.println("指定路径打印流");
        ps.close();
    }
}
