package com.zjx.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjx.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
