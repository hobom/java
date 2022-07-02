package com.itheima.controller;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.fastjson.JSON;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user",method = RequestMethod.GET)
public class UserController {

    @RequestMapping("/quick10")//请求映射，用于建立请求url和处理方法之间的对应关系
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public User save10() throws IOException {
        User user=new User();
        user.setUsername("lisi");
        user.setAge(32);
        return user;
    }

    @RequestMapping("/quick9")//请求映射，用于建立请求url和处理方法之间的对应关系
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save9() throws IOException {
        User user=new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json的转换工具将对象转换成json格式字符串再返回
        String json= JSON.toJSONString(user);
        return json;
    }

    @RequestMapping("/quick8")//请求映射，用于建立请求url和处理方法之间的对应关系
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping("/quick7")//请求映射，用于建立请求url和处理方法之间的对应关系
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() throws IOException {
        return "hello itheima";
    }

    @RequestMapping("/quick6")//请求映射，用于建立请求url和处理方法之间的对应关系
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast");
    }

    @RequestMapping("/quick5")//请求映射，用于建立请求url和处理方法之间的对应关系
    public String save5(HttpServletRequest request){
        request.setAttribute("username","hobom");
        return "success";
    }

    @RequestMapping("/quick4")//请求映射，用于建立请求url和处理方法之间的对应关系
    public String save4(Model model){
        model.addAttribute("username","博学谷");
        return "success";
    }

    @RequestMapping("/quick3")//请求映射，用于建立请求url和处理方法之间的对应关系
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //返回modelandview
    @RequestMapping("/quick2")//请求映射，用于建立请求url和处理方法之间的对应关系
    public ModelAndView save2(){
        /*
        Model:模型 封装数据
        View:视图 展示数据
        */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","itcast");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //返回字符串
    @RequestMapping("/quick")//请求映射，用于建立请求url和处理方法之间的对应关系
    public String save(){
        System.out.println("Controller save runing...");
        //加"/"代表从当前web应用下找资源，forword为转发(默认)，redirect为重定向
//        return "/jsp/success.jsp";
        //使用前后缀
        return "success";
    }
}
