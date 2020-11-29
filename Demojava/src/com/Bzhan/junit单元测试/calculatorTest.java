package com.Bzhan.junit单元测试;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class calculatorTest {
    //单元测试的实现
    //定义测试测试方法，独立运行需要加上注解junit
    //需要导入
    //断言 将结果和断言进行比较
    @Before    //所有方法执行之前都会执行该方法  一般用于资源的申请
    public void init(){
        System.out.println("init...");
    }

    //所有方法执行后都会执行，用于释放资源
    @After
    public  void close(){
        System.out.println("close...");
    }

    @Test
    public void testadd(){
        //创建对象，调用方法
        calculator c=new calculator();
        int result = c.add(1, 2);
        System.out.println(result);
        Assert.assertEquals(3,result);//利用断言来实现判断预期结果和真实运行结果是否相同

    }
    @Test
    public void testsub(){
        calculator c=new calculator();
        int sub = c.sub(1, 2);
        Assert.assertEquals(-1,sub);
    }

    //框架：半成品软件，在框架上进行开发，可以简化代码
    //反射时框架设计的灵魂

}
