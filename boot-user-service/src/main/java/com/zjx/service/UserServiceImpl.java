package com.zjx.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjx.bean.UserAddress;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

//@Service(version = "2.6.2")
@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("===========boot-user-service");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //模拟异常
//        if(Math.random() > 0.5){
//            throw new RuntimeException();
//        }
        UserAddress address = new UserAddress(1,"河南","1","张三","010-5555555","y");
        return Arrays.asList(address);
    }
}
