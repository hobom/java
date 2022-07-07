package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    void del(Long userId);

    List<User> list();
    void save(User user, Long[] roleIds);
}
