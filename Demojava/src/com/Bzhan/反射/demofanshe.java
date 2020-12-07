package com.Bzhan.反射;

import java.lang.reflect.Field;

public class demofanshe {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        //获取class类对象的三种方式
        Class cls = Class.forName("com.Bzhan.反射.Person");
        System.out.println(cls);
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);
        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);

        System.out.println(cls==cls2);
        System.out.println(cls==cls3);
        //同一个字节码文件（*.class）在一次程序运行的过程中，只会被加载一次，不论通过那种方式获取的class对象都是同一个
        //Class获取对象
        /*
        * 获取成员变量
        * 获取构造方法
        * 获取成员方法
        * 获取类名*/
        System.out.println("===========================================");
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();//获取所有public修饰的成员变量
        for (Field field:fields
             ) {
            System.out.println(field);
        }
        System.out.println("========================================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field:declaredFields
             ) {
            System.out.println(field);
        }

        System.out.println("=================================");
        Field age = personClass.getDeclaredField("age");
        //访问之前忽略访问权限修饰符的安全检查
        // TODO: 2020/12/1 不管用 ，获取不到变量的值，出现异常
        age.setAccessible(true);
        Object value = age.get(age);
        System.out.println(value);


    }
}
