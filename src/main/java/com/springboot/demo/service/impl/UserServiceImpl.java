package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.pojo.User;
import com.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-12-08 13:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //查询所有数据
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    //登陆
    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName, password);
    }

    //注册用户名唯一性校验
    @Override
    public User register(String userName) {
        return userMapper.register(userName);
    }

    //注册
    @Override
    public void userRegister(User user) {
        userMapper.userRegister(user);
    }

    //添加
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    //更新
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    //根据姓名查询
    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    //根据用户名删除
    @Override
    public void delete(String userName) {
        userMapper.delete(userName);
    }
}
