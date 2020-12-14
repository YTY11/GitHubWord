package com.springboot.demo.service;

import com.springboot.demo.pojo.User;
import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-12-08 13:40
 */
public interface UserService {
    //查询所有用户
    public List<User> findAll();

    //登陆验证
    public User login(String userName,String password);

    //注册时用户名唯一性验证
    public User register(String userName);

    //注册
    public void userRegister(User user);

    //添加用户
    public void addUser(User user);

    //更新用户
    public void updateUser(User user);

    //根据姓名查找
    public List<User> findByName(String name);

    //根据用户名删除
    public void delete(String userName);
}
