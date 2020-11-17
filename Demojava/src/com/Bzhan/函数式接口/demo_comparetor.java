package com.Bzhan.函数式接口;

import java.util.Arrays;
import java.util.Comparator;

public class demo_comparetor {
   public static Comparator<String> getcomparator(){
        /* return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };*/

        //方法的返回值是一个接口所以可以改为一个lambda表达式...00
        return (o1,o2)->{
            return o2.length()-o1.length();
        };
    }

    public static void main(String[] args) {
        String[] str={"aaa","b","cccc","ddddddddd"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str,getcomparator());
        System.out.println(Arrays.toString(str));
    }
}
