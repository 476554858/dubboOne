package com.zjx.service;

import com.zjx.bean.UserAddress;
import org.mengyun.tcctransaction.api.EnableTcc;

import java.util.List;

public interface OrderService {

    public List<UserAddress> getAddress();

    /**
     * 订单支付
     */
    @EnableTcc
    public void orderPay();
}
