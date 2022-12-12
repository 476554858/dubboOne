package com.zjx.controller;

import com.zjx.entity.User;
import com.zjx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 初始化一个账户出来，用于后边tcc的支付操作
     * 这里为了方便浏览器直接调用，使用了get请求
     * @return
     */
    @GetMapping("/ininUser")
    public Object initUser(){
        User user = userMapper.selectById(1);
        if(user == null){
            user = new User();
            user.setId(1);
            user.setBalance(100);
            userMapper.insert(user);
            return "ok";
        }
        user.setBalance(100);
        userMapper.updateById(user);
        return "ok";
    }
}
