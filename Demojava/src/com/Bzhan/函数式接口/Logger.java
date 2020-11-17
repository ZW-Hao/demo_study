package com.Bzhan.函数式接口;
/*
    日志案例

 */
public class Logger {
    //更具日志的级别显示日志的方法
    public static void main(String[] args) {

        String msg1="hello";
        String msg2="world";
        String msg3="java";

        showlogger(1,msg1+msg2+msg3);
    }

    private static void showlogger(int level,String message) {
        if(level==1){
            System.out.println(message);
        }

    }
}
