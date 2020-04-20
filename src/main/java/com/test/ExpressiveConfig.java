package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:my.properties")
/* 上面这个属性文件会加载到spring的Environment，PropertySourcesPlaceholderConfigurer又封装了Environment
 * 如果使用xml配置，可以<context:property-placeholder location="classpath:my.properties">
 */
public class ExpressiveConfig {

    @Bean
    // 配置属性占位符
    public static PropertySourcesPlaceholderConfigurer PlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
