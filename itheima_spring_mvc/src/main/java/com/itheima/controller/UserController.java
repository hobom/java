package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user",method = RequestMethod.GET,params = {"username"})
public class UserController {

    @RequestMapping("/quick")//请求映射，用于建立请求url和处理方法之间的对应关系
    public String save(){
        System.out.println("Controller save runing...");
        //加"/"代表从当前web应用下找资源，forword为转发(默认)，redirect为重定向
//        return "/jsp/success.jsp";
        //使用前后缀
        return "success";
    }
}
