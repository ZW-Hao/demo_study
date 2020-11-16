package com.Bzhan;

import java.io.Serializable;

/*
    序列换和反序列化的过程中，会抛出异常
    需要通过实现Java.io.serializable接口来启用序列化功能
    serialversionUID在类修改后会更改为新的
    可以手动添加序列号
 */
public class demo_11_11_01_person implements Serializable {
    private  static final long serialVersionUID=1l;
    private  String name;
     private  int age;

    public demo_11_11_01_person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public demo_11_11_01_person() {
    }

    @Override
    public String toString() {
        return "demo_11_11_01_person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
