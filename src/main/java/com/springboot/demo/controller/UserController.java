package com.springboot.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.pojo.User;
import com.springboot.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Yang TanYing
 * @Description:
 * @create 2020-12-08 13:42
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/indexS")
    public String index(HttpServletRequest request, Model model, @RequestParam(value = "start", defaultValue = "1") int start){
        String name = request.getParameter("name");
        request.getSession().setAttribute("name", name);
        if(name == null || name.length() <= 0){
            PageHelper.startPage(start,5);
            List<User> all = userService.findAll();
            PageInfo<User> userPageInfo = new PageInfo<>(all);
            System.out.println("===============");
            System.out.println(userPageInfo.getPageSize());
            model.addAttribute("userPageInfo", userPageInfo);
            return "index";
        }
        else {
            model.addAttribute("name",name);
            PageHelper.startPage(start, 5);
            List<User> byName = userService.findByName(name);
            PageInfo<User> findInfo = new PageInfo<>(byName);
            model.addAttribute("userPageInfo", findInfo);
            return "index";
        }

    }

    //用户登陆校验
    @RequestMapping("/userLogin")
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String USER_NAME = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.login(USER_NAME, password);
        if(user != null){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }
    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }

    //注册用户名唯一性校验
    @RequestMapping("/registerName")
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String registerName = request.getParameter("registerName");
        User register = userService.register(registerName);
        if(register != null){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }
    //注册用户名唯一性校验
    @RequestMapping("/addName")
    public void addName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        User register = userService.register(userName);
        if(register != null){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }

    //注册
    @RequestMapping("/userRegister")
    public void userRegister(User user,HttpServletResponse response) throws IOException {
        userService.userRegister(user);
        System.out.println("注册成功!!!");
        response.getWriter().write("true");
    }


    //添加用户
    @RequestMapping("/addUser")
    public void addUser(User user,HttpServletResponse response) throws IOException {
        userService.addUser(user);
        System.out.println("添加成功！！");
        response.getWriter().write("true");
    }

    //更新用户
    @RequestMapping("/updateUser")
    public void updateUser(User user,HttpServletResponse response) throws IOException {
        user.setUpdateTime(new Date());//更新時間
        userService.updateUser(user);
        System.out.println("更新成功！！");
        response.getWriter().write("true");
    }

//    //根据用户名删除
//    @RequestMapping("/delete/{userName}")
//    public void delete(@PathVariable String userName,HttpServletResponse response) throws IOException {
//        userService.delete(userName);
//       response.sendRedirect("/indexS");
//    }

}
