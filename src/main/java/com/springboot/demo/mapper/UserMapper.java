package com.springboot.demo.mapper;

import com.springboot.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-12-08 13:39
 */
@Mapper
public interface UserMapper {
    //查询所有用户
//    @Select("select * from HERMES_USER")
    public List<User> findAll();

    //登陆验证
    @Select("select * from HERMES_USER where USER_NAME = #{userName} and PASSWORD = #{password}")
    public User login(String userName,String password);

    //注册时用户名唯一性验证
    @Select("select * from HERMES_USER where USER_NAME = #{userName}")
    public User register(String userName);

    //注册
    @Insert("insert into HERMES_USER (USER_NAME,PASSWORD,POST) values(#{userName},#{password},#{post})")
    public void userRegister(User user);

    //添加用户
    @Insert("insert into HERMES_USER (USER_NAME,NAME,PASSWORD,POST,E_MAIL,NUMBER_ID,FLOOR) values(#{userName},#{name},#{password},#{post},#{email},#{numberId},#{floor})")
    public void addUser(User user);

    //更新用户
    @Update("update HERMES_USER set NAME=#{name},PASSWORD=#{password},POST=#{post},E_MAIL=#{email},NUMBER_ID=#{numberId},UPDATE_TIME=#{updateTime},FLOOR=#{floor} where USER_NAME=#{userName}")
    public void updateUser(User uesr);

    //根据用户名查找
    @Select("select * from HERMES_USER where NAME like '%${name}%'")
    public List<User> findByName(String name);

    //根据用户名删除
    @Delete("delete from HERMES_USER where USER_NAME=#{userName}")
    public void delete(String userName);
}
