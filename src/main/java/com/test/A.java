package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Value("${country}")
    String country;
    @Value("${capital}")
    String capital;

    public void a() {
        System.out.println(country);
        System.out.println(capital);

    }
}
