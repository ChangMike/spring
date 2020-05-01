package com.test;

import java.sql.*;

/*
 * 创建数据库JDBCTest，并建立book表，book表两个字段分别是title、author
 */

public class Main {
    //说明JDBC驱动的名称和数据库的地址
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/JDBCTest?useSSL=false&serverTimezone=UTC";

    //说明数据库的认证账户及密码
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        //注册JDBC驱动
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            //这里会发生类没有找到的异常！
            e.printStackTrace();
        }
        //获得数据库连接
        try {
            Connection connection =  DriverManager.getConnection(DB_URL,USER,PASS);
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
