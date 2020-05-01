package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;

/*
 * 创建数据库JDBCTest，并建立book表，book表两个字段分别是title、author
 */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ComboPooledDataSource dataSource = context.getBean(ComboPooledDataSource.class);
        //获得数据库连接
        try {
            //执行查询语句
            Connection connection = dataSource.getConnection();
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
