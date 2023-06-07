package com.example.springboot.servise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class Person {
    @Bean
    public  String Sex (){
        return "11";
    }
}
