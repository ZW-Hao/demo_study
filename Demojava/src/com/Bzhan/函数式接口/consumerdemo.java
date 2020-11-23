package com.Bzhan.函数式接口;

import java.util.function.Consumer;

/*
    Consumer接口用来消费一个数据

 */
public class consumerdemo {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("赵丽颖",(String name)->{
            //对传递的字符串进行消费
            System.out.println(name);
        });
    }
}
