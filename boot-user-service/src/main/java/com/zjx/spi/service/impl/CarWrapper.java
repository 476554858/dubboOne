package com.zjx.spi.service.impl;

import com.alibaba.dubbo.common.URL;
import com.zjx.spi.service.Car;

/**
 * dubbo spi测试包装类
 */
public class CarWrapper implements Car {

    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public void getColor(URL url) {
        System.out.println("before...");
        car.getColor(url);
        System.out.println("after...");
    }
}
