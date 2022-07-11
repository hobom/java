package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    User findByUsernameAndPassWord(String username, String password);
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
