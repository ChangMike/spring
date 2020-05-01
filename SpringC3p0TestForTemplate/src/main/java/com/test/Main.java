package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/*
 * 创建数据库JDBCTest，并建立book表，book表两个字段分别是title、author
 */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // JdbcOperations是一个接口，定义了JdbcTemplate所实现的操作。通过注入JdbcOperations，能保证和JdbcTemplate的松耦合
        JdbcOperations jdbcOperations = context.getBean(JdbcOperations.class);
        List<Map<String, Object>> maps = jdbcOperations.queryForList("SELECT * FROM book");
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> map = maps.get(i);
            Object title = map.get("title");
            Object author = map.get("author");
            System.out.println(title);
            System.out.println(author);
        }
    }
}
