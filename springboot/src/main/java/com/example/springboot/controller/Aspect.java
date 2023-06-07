package com.example.springboot.controller;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Before("execution(* com.example.springboot.controller.HelloController.Hey())")
    public void test(){
        System.out.println("befor");
    }
}
