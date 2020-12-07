package com.Bzhan.注解;

public class calculator {

@Check
    public static int add(int a,int b){
        return a+b;
    }
@Check
    public static int sub(int a,int b){
        return a/b;
    }

    public static void main(String[] args) {
        System.out.println(add(1,1));
        System.out.println(sub(1,0));
    }


}
