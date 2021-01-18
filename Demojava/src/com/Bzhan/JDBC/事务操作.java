package com.Bzhan.JDBC;

import com.Bzhan.JDBC.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 创建人：Hzw
 * 创建时间：2021/1/17
 * 描述：
 */
public class 事务操作 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        String sql1="update moneyTable set money=money-? where name=?";
        String sql2="update moneyTable set money=money+? where name=?";


        try {
            conn.getAutoCommit();//开启事务
            conn = JDBCUtils.getConnection();
            pstmt1=conn.prepareStatement(sql1);
            pstmt2=conn.prepareStatement(sql2);

            pstmt1.setInt(1,500);
            pstmt1.setString(2,"zhangsan");

            pstmt2.setInt(1,500);
            pstmt2.setString(2,"lisi");

            pstmt1.executeUpdate();
            int i=1/0;
            pstmt2.executeUpdate();
            conn.commit();//提交事务
        } catch (Exception throwables) {//无论发生任何异常，都要回滚
                try {
                    if (conn!=null){
                        conn.rollback();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }

    }
}
