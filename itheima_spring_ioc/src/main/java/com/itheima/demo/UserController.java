package com.itheima.demo;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app=new FileSystemXmlApplicationContext("D:\\code\\java\\Projects\\Spring\\itheima_spring_ioc\\src\\main\\resources\\applicationContext.xml");

        //适用于存在多个相同对象类型时
//        UserService userService = (UserService) app.getBean("userService");
        //适用于存在一个对象类型时
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
