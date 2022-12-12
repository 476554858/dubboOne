package com.zjx.controller;

import com.zjx.bean.UserAddress;
import com.zjx.entity.Order;
import com.zjx.mapper.OrderMapper;
import com.zjx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @ResponseBody
    @RequestMapping("getAddress")
    public List<UserAddress> getAddress() {
        return orderService.getAddress();
    }

    /**
     * 订单初始化，为支付操作准备
     * @return
     */
    @ResponseBody
    @GetMapping("initOrder")
    public Object payOer() {
        Order order = orderMapper.selectById(1);
        if(order == null){
            order = new Order();
            order.setAmount(20);
            order.setUserId(1);
            order.setStatus(0);
            orderMapper.insert(order);
            return "ok";
        }
        order.setStatus(0);
        order.setAmount(20);
        orderMapper.updateById(order);
        return "ok";
    }
}
