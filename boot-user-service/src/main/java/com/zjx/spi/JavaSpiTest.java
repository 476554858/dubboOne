package com.zjx.spi;

import com.zjx.service.UserService;

import java.util.Iterator;
import java.util.ServiceLoader;

public class JavaSpiTest {

    public static void main(String[] args) {
        ServiceLoader<UserService> serviceLoader = ServiceLoader.load(UserService.class);
        Iterator<UserService> iterator = serviceLoader.iterator();
        // java spi不能单独的获取某个指定的实现类
        // java spi没有ioc和aop机制
        while (iterator.hasNext()){
            UserService next = iterator.next();
            System.out.println(next);
        }
    }
}
