package com.zjx.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjx.bean.UserAddress;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    //@Reference(loadbalance="roundrobin") 轮询
    @Reference
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder() {
        List<UserAddress> addresses = userService.getUserAddressList();
        return addresses;
    }


    public List<UserAddress> hello(){
        UserAddress ua = new UserAddress(10,"测试地址","1","调试","调试","Y");
        List<UserAddress> list = new ArrayList<UserAddress>();
        list.add(ua);
        return list;
    }
}
