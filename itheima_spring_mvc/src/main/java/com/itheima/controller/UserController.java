package com.itheima.controller;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.fastjson.JSON;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value="/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick17/{username}")//Restful风格
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping("/quick16")
    @ResponseBody
    //requestParam 参数绑定注解，
    // value：请求的参数名称
    // required 指定的请求参数是否必须包括
    // defaultValue 当没有指定请求参数时，则使用直嘀咕的默认值赋值
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "hobom") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    //将list封装到vo对象中List<User> userList->VO vo
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    //获得请求的集合数据类型，springmvc自动封装
    @RequestMapping("/quick14")
    @ResponseBody
    //将list封装到vo对象中List<User> userList->VO vo
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    //获得请求的数组类型，springmvc自动封装
    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    //获得请求的polo数据类型，springmvc自动封装
    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    //获得请求的基本数据类型，自动赋值
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

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
