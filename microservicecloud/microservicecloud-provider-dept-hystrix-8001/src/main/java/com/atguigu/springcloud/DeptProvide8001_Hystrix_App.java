package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册金eureka
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //对Hystrix熔断机制的支持TEST
public class DeptProvide8001_Hystrix_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvide8001_Hystrix_App.class, args);
	}

}
