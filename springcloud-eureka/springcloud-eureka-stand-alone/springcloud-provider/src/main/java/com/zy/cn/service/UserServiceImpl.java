package com.zy.cn.service;

import com.zy.cn.dao.UserDAO;
import com.zy.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void inseret(User user) {
        userDAO.insert(user);
    }

    @Override
    public List<User> queryAll() {
        return userDAO.queryAll();
    }

    @Override
    public User find(Integer id) {
        return userDAO.find(id);
    }
}
