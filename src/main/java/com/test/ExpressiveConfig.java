package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:my.properties") // 如果不指定文件，会得到null
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public A a() {
        A a = new A(env.getProperty("country"), env.getProperty("capital"));
        return a;

    }

}
