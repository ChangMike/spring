package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Config {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    public static void configDataSource(){
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JDBCTest?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setInitialPoolSize(3);
            dataSource.setMaxPoolSize(10);
            dataSource.setMinPoolSize(3);
            dataSource.setAcquireIncrement(3);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        configDataSource();
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
