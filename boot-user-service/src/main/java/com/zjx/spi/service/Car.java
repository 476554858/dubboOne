package com.zjx.spi.service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Car {

    @Adaptive(value = "carType")
    public void getColor(URL url);
}
