package com.zjx.service;

import com.zjx.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public List<UserAddress> getAddress();

    public void orderPay();
}
