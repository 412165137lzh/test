package com.lzh.service;

import com.lzh.dao.UserMapper;
import com.lzh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User getUserById(String uid){
        return userMapper.getUserById(uid);
    }
}
