package com.config;

import com.test.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Conditional(MyCondition.class)
    public A a() {
        return new A();
    }
}
