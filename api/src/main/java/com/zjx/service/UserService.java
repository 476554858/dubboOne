package com.zjx.service;

import com.zjx.bean.UserAddress;
import org.mengyun.tcctransaction.api.EnableTcc;

import java.util.List;

public interface UserService {

    public List<UserAddress> getUserAddressList();

    /**
     * 支付
     * @param userId
     * @param amount 订单金额
     */
    @EnableTcc
    public String orderPay(Integer userId, Integer amount);
}
