package com.zjx;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo //开启基于注解的dubbo功能
@ImportResource(locations= {"classpath:provider.xml", "classpath:appcontext-service-tcc.xml"})
//@EnableDubbo(scanBasePackages="com.zjx.service")
@EnableHystrix //开启服务容错
@SpringBootApplication
public class BootUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootUserServiceApplication.class, args);
	}
}
