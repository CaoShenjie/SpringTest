package com.example.springboot.controller;

import com.example.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/Hello"},method = RequestMethod.GET)
    public String Hey(){
        userService.getClass();
        return "zilv";
    }
}
