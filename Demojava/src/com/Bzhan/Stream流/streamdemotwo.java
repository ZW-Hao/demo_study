package com.Bzhan.Stream流;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class streamdemotwo {
    public static void main(String[] args) {
        //stream流只能使用一次，使用完后自动关闭，如果以后再次调用这个流，会抛出异常
        Stream<String> streamone = Stream.of("123", "234", "345");
        Stream<String> streamtwo = streamone.filter((str) -> {
            if (str.startsWith("1")) {
                return true;
            } else {
                return false;
            }
        });
        streamtwo.forEach((str)->{
            System.out.println(str);
        });
        //未省略lambda表达式写法
        Stream<String> streamthree = Stream.of("张", "王", "李");
        streamthree.filter((String str)->{
            if (str.startsWith("张")){
                return true;
            }
            return false;
        })
                .forEach(
                        (String str)->{
                            System.out.println(str);
                        }
                );

        //匿名内部类实现方式
        Stream<String> streamfour = Stream.of("zhang", "wang", "li", "zhoa");

        streamfour.filter(
                new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        if(s.startsWith("zh")){
                            return true;
                        }
                        return false;
                    }
                }
        )
                .forEach(
                        new Consumer<String>() {
                            @Override
                            public void accept(String s) {
                                if(s.startsWith("zha")){
                                    System.out.println(s);
                                }
                            }
                        }
                );

        Stream<String> stream1 = Stream.of("1", "2");
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        Stream<? extends Serializable> concat = Stream.concat(stream1, stream2);
                concat.forEach(str-> System.out.println(str));


    }
}
