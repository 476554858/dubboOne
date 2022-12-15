package com.zjx.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("t_order")
public class Order {

    // 订单id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 用户id
    @TableField("user_id")
    private Integer userId;

    // 金额
    private Integer amount;

    // 订单状态：0，未支付，1，支付中，2，已支付
    private Integer status;
}
