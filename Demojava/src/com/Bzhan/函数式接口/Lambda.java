package com.Bzhan.函数式接口;

public class Lambda {
    public static void main(String[] args) {
        String msg1="hello";
        String msg2="world";
        String msg3="java";
        showLogger(1,()->{
            //返回一个拼接好的字符串
            return msg1+msg2+msg3;
        });
    }

    private static void showLogger(int level,Mesagebulider mb) {
        if(level==1){
            System.out.println(mb.buliderMessage());
        }
    }
}
