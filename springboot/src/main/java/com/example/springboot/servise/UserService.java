package com.example.springboot.servise;

import com.example.springboot.SpringbootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnBean(Person.class)
public class UserService {
}
