package com.zjx.spi.service.impl;

import com.alibaba.dubbo.common.URL;
import com.zjx.spi.service.Car;

public class RedCar implements Car {
    @Override
    public void getColor(URL url) {
        System.out.println("red");
    }
}
