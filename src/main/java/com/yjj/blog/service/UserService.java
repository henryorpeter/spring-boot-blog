package com.yjj.blog.service;

import com.yjj.blog.po.User;

public interface UserService {
    User checkUser(String username,String password);
}
