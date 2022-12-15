package com.zjx.service;

import com.zjx.bean.UserAddress;
import com.zjx.entity.User;
import com.zjx.mapper.UserMapper;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

//@Service(version = "2.6.2")
//@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

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

    /**
     * 订单支付
     * @param userId
     * @param amount 订单金额
     */
    @Compensable(confirmMethod = "confirmPay", cancelMethod = "orderPayCancel", asyncCancel = true)
    @Transactional
    @Override
    public String orderPay(Integer userId, Integer amount) {
        User user = userMapper.selectById(userId);
        user.setBalance(user.getBalance() - amount);
        Integer count = userMapper.updateById(user);
        if(count != 1){
            return "error";
        }
        return "success";
    }

    public void confirmPay(Integer userId, Integer amout){
        System.out.println(userId + ":支付成功");
    }

    public void orderPayCancel(Integer userId, Integer amount){
        User user = userMapper.selectById(userId);
        user.setBalance(user.getBalance() + amount);
        userMapper.updateById(user);
    }
}
