package com.mn.springboot.service.impl;

import com.mn.springboot.entity.User;
import com.mn.springboot.mapper.UserMapper;
import com.mn.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
