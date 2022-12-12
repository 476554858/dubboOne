package com.zjx.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    // 账户id
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 账户余额
    private Integer balance;
}
