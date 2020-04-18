package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    @Test
    public void my() {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.test.Config.class);
        A a = context.getBean(A.class);
        a.print();
    }

    @Test
    public void my2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("my.xml");
        A a = context.getBean(A.class);
        a.print();
    }


}
