package com.Bzhan.XML.JSoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/23
 * 描述：
 */
public class JSoup对象 {
    public static void main(String[] args) throws IOException {
        //获取Document对象，根据xml文档获取
        //获取student.xml的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("com/Bzhan/XML/JSoup/student.xml").getPath();

        //解析xml文档，加载文档进内存，获取dom树--->Document
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);

//        URL url=new URL("https://www.baidu.com/?tn=80035161_1_dg");
//        Document document1 = Jsoup.parse(url, 3000);
//        System.out.println(document1);


    }
}
