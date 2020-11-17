package com.Bzhan.函数式接口;

public class demoRunna {
    //定义一个方法startthread（）参数使用函数式接口runnable
    public static void starThread(Runnable run){
        new Thread(run).start();
    }

    public static void main(String[] args) {
        starThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动了");
            }
        });

        starThread(()->{
            System.out.println(Thread.currentThread().getName()+"线程启动了");
        });
    }
}
