package com.courage.shardingsphere.jdbc.service;

import com.courage.shardingsphere.jdbc.domain.mapper.UserMapper;
import com.courage.shardingsphere.jdbc.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

}
