package com.Bzhan.JDBC.Utils;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/17
 * 描述：
 */
public class demo {
    public static void main(String[] args) {
        String account="123";
        String password="a' or 'a'='a";
        String sql="select * from users where username ='"+account+"' and userpassword = '"+password+"'";
        System.out.println(sql);

    }
}
