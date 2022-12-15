package com.zjx.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjx.bean.UserAddress;

import java.util.Arrays;
import java.util.List;

@Service(version = "2.0.0")
public class UserServiceImpl2 implements UserService{

//    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList() {
        System.out.println("===========boot-user-service-new");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        UserAddress address = new UserAddress(1,"河南","1","张三","010-5555555","y");
        return Arrays.asList(address);
    }

    @Override
    public String orderPay(Integer userId, Integer amount) {
        return null;
    }
}
