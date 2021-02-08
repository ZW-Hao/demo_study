package com.Bzhan.XML.JSoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/23
 * 描述：
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取Document对象，根据xml文档获取
        //获取student.xml的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("com/Bzhan/XML/JSoup/student.xml").getPath();

        //解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //获取数据对象
        Element element = elements.get(1);

        String text = element.text();
        System.out.println(text);

    }
}
