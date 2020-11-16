package com.Bzhan;

import java.io.*;

/*
    static 修饰的变量不能序列化

    序列化和反序列化
        把对象以流的方式写入到文件中保存，叫做写对象，也叫做对象的序列化
        对象中不仅仅是字符，使用字节流
        Objectoutputstream 对象的序列化流


        把文件中保存的对象，以流的方式读取出来，叫做读对象，也叫做对象的反序列化
        Objectinputstream 对象的反序列化流


        Objectoutputstream 使用步骤
            创建对象，构造方法中传入字节输出流
            使用writeobject（）方法，将对象写入到文件中
            释放资源

        objectonputstream 使用步骤
            创建对象，构造方法中传入字节输入流
            使用readobject（）方法读取文件中的对象
            释放资源
            打印读取出来的对象
 */
public class demo_11_11_01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src\\File\\person.txt"));
        oos.writeObject(new demo_11_11_01_person("小美女",18));
        oos.close();

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src\\File\\person.txt"));
        Object o=ois.readObject();
        ois.close();
        System.out.println(o);
        demo_11_11_01_person p=(demo_11_11_01_person)o;
        System.out.println(p.getName()+"  "+p.getAge());

    }
}
