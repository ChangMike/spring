package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //获得数据库连接
        try {
            Connection connection =  C3p0Config.getConnection();
            //执行查询语句
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book";
            ResultSet rs =statement.executeQuery(sql);
            while (rs.next())
            {
                String title = rs.getString("title");
                String author = rs.getString("author");
                System.out.println(title+":"+author);
            }
            //关闭连接资源
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //这里会发生SQL异常，因为我们提供的的账户和密码不一定能连接成功
        }
    }
}
