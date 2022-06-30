package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service("userService")
//@Scope("prototype")//多例
@Scope("singleton")//单例
public class UserServiceImpl implements UserService {

    //普通数据类型的注解，同过Spring获得值
    @Value("${jdbc.driver}")
    private String driver;

    @Autowired//按照数据类型从Spring容器中匹配
    //@Qualifier("userDao")//按照id名称从容器中匹配 但是此处要结合Autowired一起使用
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    public void inin(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
