package com.Bzhan.函数式接口;

import java.util.function.Supplier;

/*

    Supplier接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据
 */
public class Supplierdemo {
    //定义一个方法，参数传递supplier接口
    public static Integer getmax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] array={10,0,-50,88,99,33,-30};
        Integer getmax = getmax(() -> {
            //获取数组的最大值并返回
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;
        });
        System.out.println(getmax);

    }




    /*public static void main(String[] args) {
        String s = getstring(() -> {
            return "胡歌";
        });
        System.out.println(s);


        String a=getstring(
                new Supplier<String>() {
                    @Override
                    public String get() {
                        return "胡歌";
                    }
                }
        );
        System.out.println(a);

    }*/


}
