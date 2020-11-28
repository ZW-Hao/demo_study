package com.Bzhan.Stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Streamdemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        List<String> listzhang=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).startsWith("张")){
                listzhang.add(list.get(i));
            }
        }
        for (int i = 0; i < listzhang.size(); i++) {
            System.out.println(listzhang.get(i));
        }

        List<String> listchang=new ArrayList<>();
        for (int i = 0; i < listzhang.size(); i++) {
            if(listzhang.get(i).length()==3){
                listchang.add(listzhang.get(i));
            }
        }
        for (int i = 0; i < listchang.size(); i++) {
            System.out.println(listchang.get(i));
        }


        //stream流通常结合函数式接口和lambda表达式形式使用
        // 用来洗数据，得到自己想要的数据在用来进行处理


        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(System.out::println);

        System.out.println("===========================");

        //未省略的lambda表达式写法
        list.stream()
                .filter(( name)->{
                    if (name.startsWith("张")){
                        return true;
                    }
                    return false;
                })
                .filter(( name)->{if (name.length()==3){return true;};
                    return false;
                })
                .forEach((name)->{
                    System.out.println(name);
                });

        System.out.println("===============================");

        //匿名内部类实现
        list.stream()
                .filter(
                        new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                if(s.startsWith("张")){
                                    return true;
                                }else {
                                    return false;
                                }
                            }
                        }
                )
                .filter(
                        new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                if (s.length()==3){
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                        }
                )
                .forEach(
                        new Consumer<String>() {
                            @Override
                            public void accept(String s) {
                                //用于对此时集合中存在的元素的处理
                                System.out.println(s);
                            }
                        }
                );


    }
}
