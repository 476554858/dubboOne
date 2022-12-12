package com.zjx.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjx.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
