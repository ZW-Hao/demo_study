package com.Bzhan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

/*
    java.util.properties
    properties类是一个持久的属性集。可保存在流中或从流中加载
    properties集合是唯一一个和IO流相结合的集合
            store  把集合中的临时数据，持久化写入到硬盘中
            load   把硬盘中的数据读取到集合中使用

    双列集合：key和value默认都是字符串
 */
public class demo_11_08_03 {
    public static void main(String[] args) throws IOException {
        //showo1();
        show02();
        show03();
    }
    /*
        读取文件中的集合
        load
        void load()
     */
    private static void show03() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("src\\File\\d.txt"));
        Set<String> set = prop.stringPropertyNames();

        for(String key:set){
            String value=prop.getProperty(key);
            System.out.println(key+value);
        }

    }

    private static void show02() throws IOException {
        Properties prop=new Properties();
        //向集合中添加数据
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","162");
        prop.setProperty("古力娜扎","165");

        FileWriter fw=new FileWriter("src\\File\\d.txt");

        prop.store(fw,"baocun");
        fw.close();
    }

    /*
        store
        void store(Outputstream out,String c)字节输出流
        void store(Writer w,String c)字符输出流  c是解释保存的文件是干什么用的（不能是中文），一般是一个空字符串
     */

    /*
        使用properties集合存储数据，遍历集合取出集合中的数据
     */
    private static void showo1() {
        Properties prop=new Properties();
        //向集合中添加数据
        prop.setProperty("赵丽颖","168");
        prop.setProperty("迪丽热巴","168");
        prop.setProperty("古力娜扎","168");

        //遍历集合
        //将key取出放到set集合中
        Set<String> set=prop.stringPropertyNames();

        //遍历set集合，取出键对应的值
        for (String key:set) {
            String value=prop.getProperty(key);
            System.out.println(key+"="+value);
        }

    }
}
