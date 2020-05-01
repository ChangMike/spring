package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Config {

    //c3p0会扫描C3p0Config.xml，加载名字为“test”的配置文件
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("test");

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
