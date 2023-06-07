package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* @SpringBootApplication  包含@SpringBootConfiguration、@EnableAutoConfiguration、@Component
    @SpringBootConfiguration 它实际上就是一个 @Configuration 注解，加上这个注解就是为了让当前类作为一个配置类交由
Spring 的 IOC 容器进行管理；
    @EnableAutoConfiguration 它是一个由 @AutoConfigurationPackage(自动配置的核心) 和 @Import 注解组成的复合注解
    @Component 开启包扫描、配置和自动配置的功能,用于定义Spring的扫描路径 等价于xml 文件中的 context:component-text
假如不配置扫描路径，那么 Spring 就会默认扫描当前类所在的包及其子包中的所有标注了 @Component，@Service，@Controller 等注解的类
*/

public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
