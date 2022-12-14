package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.strategy.QueryStrategy;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User save(@NonNull User user) {

        User user1 = userDao.getByUserName(user.getUserName());
        if (user1 == null) {
            return userDao.save(user);
        }
        return null;
    }



}
