package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void del(Long userId) {
        //1、删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        //2、删除sys_user表
        userDao.del(userId);
    }

    @Override
    public List<User> list() {
        List<User> userList=userDao.findAll();
        //封装userList中的每一个User的roles
        for (User user : userList) {
            //获得user的id
            Long id=user.getId();
            //将id作为参数查询当前userId对应的Role集合数据
            List<Role>roles=roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据
        Long userId=userDao.save(user);
        System.out.println(userId);
        //第二部 向sys_user_role关系表中存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }
}
