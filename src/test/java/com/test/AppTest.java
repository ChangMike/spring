package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest
{
    @Test
    public void myTest()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
        A a = context.getBean(A.class);
        System.out.println(a.country);
        System.out.println(a.capital);
    }
}
