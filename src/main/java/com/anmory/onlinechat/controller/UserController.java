package com.anmory.onlinechat.controller;

import com.anmory.onlinechat.model.User;
import com.anmory.onlinechat.model.UserMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-08 下午10:18
 */

@RestController
public class UserController {
    @Resource
    UserMapper userMapper;
    @PostMapping("/login")
    @ResponseBody// 不需要显式添加，因为RestController已经包含了Controller和ResponseBody
    public Object login(String username, String password, HttpServletRequest request) {
        // 1.先检查数据库中是否有这个用户以及用户名和密码是否匹配
        User user = userMapper.SelectByUsername(username);
        if(user == null || !user.getPassword().equals(password)) {
            // 当不存在这个用户或者用户名密码不匹配的时候，就返回一个空对象
            System.out.println("用户名和密码不匹配" + user);
            return new User();
        }
        // 2.如果匹配，那么就要开启会话
        HttpSession session = request.getSession(true);// session在请求里面，所以要从请求里面获取
        session.setAttribute("user",user);// 保存session对象，以便后续使用
        System.out.println("注册成功" + user);
        return user;
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(String username, String password) {
        // 1.检查用户名是否重复
        User duplicateUser = userMapper.SelectByUsername(username);
        if(duplicateUser != null) {
            System.out.println("用户名重复，请重新注册");
            return new User();
        }
        // 2.用户名不重复，注册用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int ret = userMapper.InsertUser(user);
        if(ret == 1) {
            System.out.println("注册成功");
            return user;
        }
        return new User();
    }
}
