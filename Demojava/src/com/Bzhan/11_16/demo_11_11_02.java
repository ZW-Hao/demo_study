package com.Bzhan;

import java.io.*;
import java.util.ArrayList;

public class demo_11_11_02 {
    /*
        序列化集合
            文件中保存多个对象中的时候，可以把多个对象存储到一个集合中，对集合进行序列化

        对集合进行序列化和反序列化
        分析
            定义一个存储person对象的arraylist集合
            向集合中存储person对象
            创建一个序列化流对象
            使用writerobject（）方法对集合进行序列化
            创建一个反序列化流对象
            使用readobject方法读取文件中保存的集合
            将object类型的集合转换为arraylist类型
            遍历array list集合
            释放资源

     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<demo_11_11_01_person> list=new ArrayList<>();
        list.add(new demo_11_11_01_person("张三",19));
        list.add(new demo_11_11_01_person("李四",29));
        list.add(new demo_11_11_01_person("王五",17));

        //对集合进行序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src\\File\\person.txt"));
        oos.writeObject(list);
        oos.close();

        //反序列化并打印
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src\\File\\person.txt"));
        Object o=ois.readObject();
        ois.close();

        ArrayList<demo_11_11_01_person> listone=(ArrayList<demo_11_11_01_person>)o;
        for (com.Bzhan.demo_11_11_01_person demo_11_11_01_person : listone) {
            System.out.println(demo_11_11_01_person.getName() + " " + demo_11_11_01_person.getAge());
        }



    }
}
