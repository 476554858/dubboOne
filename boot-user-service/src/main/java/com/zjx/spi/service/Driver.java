package com.zjx.spi.service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Driver {

    public void dirveCar(URL url);
}
