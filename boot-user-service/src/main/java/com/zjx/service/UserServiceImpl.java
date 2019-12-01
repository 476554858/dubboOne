package com.zjx.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjx.bean.UserAddress;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("===========boot-user-service");
        UserAddress address = new UserAddress(1,"河南","1","张三","010-5555555","y");
        return Arrays.asList(address);
    }
}
