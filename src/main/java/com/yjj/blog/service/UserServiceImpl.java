package com.yjj.blog.service;

import com.yjj.blog.dao.UserRepository;
import com.yjj.blog.po.User;
import com.yjj.blog.uilt.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/15
 * \* Time: 21:39
 * \
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User checkUser(String username, String password) {
        User user = repository.findUserByUsernameAndPassword(username, MD5Utils.md5(password));
        return user;
    }
}