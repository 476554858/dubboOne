package com.zjx.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zjx.bean.UserAddress;
import com.zjx.entity.Order;
import com.zjx.mapper.OrderMapper;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.EnableTcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Reference(version = "1.0.0", loadbalance="roundrobin") //轮询
//    @Reference(timeout = 2000, retries = 3, version = "*")
//    @Reference(stub = "com.zjx.service.SubUserService")
//    @Reference(url = "127.0.0.1:20880")
    private UserService userService;

    @Autowired
    private OrderMapper orderMapper;


//    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> getAddress() {
        List<UserAddress> addresses = userService.getUserAddressList();
        return addresses;
    }

    public List<UserAddress> hello(){
        UserAddress ua = new UserAddress(10,"测试地址","1","调试","调试","Y");
        List<UserAddress> list = new ArrayList<UserAddress>();
        list.add(ua);
        return list;
    }

    /**
     * 订单支付
     * @return
     */
    @Compensable(confirmMethod = "comfirmPay", cancelMethod = "cancelPay", asyncCancel = true)
    @Override
    public void orderPay() {
        Order order = orderMapper.selectById(1);
        // 修改状态为支付中
        order.setStatus(1);
        orderMapper.updateById(order);
        String res = userService.orderPay(1, order.getAmount());
        if("success".equals(res)){
            if(true){
                throw new RuntimeException("认为制造异常");
            }
            // 修改支付状态为已支付
            order.setStatus(2);
            orderMapper.updateById(order);
        }
    }

    public void comfirmPay(){
        Order order = orderMapper.selectById(1);
        order.setStatus(2);
        orderMapper.updateById(order);
    }

    public void cancelPay(){
        Order order = orderMapper.selectById(1);
        order.setStatus(0);
        orderMapper.updateById(order);
    }



}
