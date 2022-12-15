package com.zjx.service;

import com.zjx.bean.UserAddress;

import java.util.List;

//本地存根
public class SubUserService implements UserService{
    private UserService userService;

    public SubUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("调用本地存根");
        //模拟判断条件
        if(true){
            return userService.getUserAddressList();
        }
        return null;
    }

    @Override
    public String orderPay(Integer userId, Integer amount) {
        return null;
    }
}
