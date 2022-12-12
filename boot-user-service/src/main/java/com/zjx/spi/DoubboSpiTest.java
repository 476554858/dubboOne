package com.zjx.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.zjx.spi.service.Driver;

import java.util.HashMap;
import java.util.Map;

public class DoubboSpiTest {

    public static void main(String[] args) {
        // 每个接口对应一个ExtensionLoader
//        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
//        Car redCar = extensionLoader.getExtension("red");
//        redCar.getColor(null);
//
//        Car blackCar = extensionLoader.getExtension("black");
//        blackCar.getColor(null);

        // 测试dubbo spi自动注入
        ExtensionLoader<Driver> driverExtensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver = driverExtensionLoader.getExtension("tracker");
        Map<String, String> map = new HashMap<String, String>();
        map.put("carType", "red");
        URL url = new URL("", "", 0, map);
        driver.dirveCar(url);
    }
}
