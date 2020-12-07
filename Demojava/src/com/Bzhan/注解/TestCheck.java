package com.Bzhan.注解;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    //简单的测试框架
    public static void main(String[] args) throws IOException {
        calculator c=new calculator();

        Class cls=c.getClass();
        Method[] methods = cls.getMethods();
        int number=0;//记录异常系数
        BufferedWriter bw=new BufferedWriter(new FileWriter("src\\File\\bug.txt"));
        for (Method method : methods) {
            //判断方法上是否有check注解
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                   //捕获异常，记录信息
                    number++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称"+e.getCause());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause());
                    bw.newLine();
                    bw.write("------------------------------");
                }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
