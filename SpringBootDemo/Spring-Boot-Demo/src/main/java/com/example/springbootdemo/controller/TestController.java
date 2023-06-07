package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.ToDoubleBiFunction;

/**
 * className: TestController
 * description: TODO
 * date: 2023/5/16 21:01
 * author: csj
 * version: 1.0
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    /*
     * @Title: index
     * @Description: TODO
     * @Author: csj
     * @DateTime: 2023/5/16 21:10
     * @param a
     * @return java.lang.String
     * @throws
     */
    public String index() {
        return "TestController From SpringBoot !";
        // TODO: 2023/5/16
    }
}