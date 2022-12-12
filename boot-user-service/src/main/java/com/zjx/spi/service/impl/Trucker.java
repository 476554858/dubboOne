package com.zjx.spi.service.impl;

import com.alibaba.dubbo.common.URL;
import com.zjx.spi.service.Car;
import com.zjx.spi.service.Driver;

/**
 * dubbo spi测试自动注入
 */
public class Trucker implements Driver {

    private Car car;

    public void setCar(Car car){
        this.car = car;
    }

    @Override
    public void dirveCar(URL url) {
        car.getColor(url);
    }
}
