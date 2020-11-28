package com.Bzhan.方法引用;

import java.awt.print.Printable;

public class demo01printable {
    //传递接口实现打印
    public static void printString(printable p){
        p.printstring("helloword");
    }

    //显示字符串的大写表示方法
    public static void printUppercase(printable p){
        p.printstring("hello");

    }
    public static void main(String[] args) {
//        printString(System.out::println);
        printUppercase((str)->{
            String s = str.toUpperCase();
            System.out.println(s);

        });
    }
}
