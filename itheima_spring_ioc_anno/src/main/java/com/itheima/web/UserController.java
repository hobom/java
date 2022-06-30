package com.itheima.web;

import com.itheima.config.DataSourceConfiguration;
import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //注解声明上下文
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
