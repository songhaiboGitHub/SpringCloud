package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册金eureka
@EnableDiscoveryClient //服务发现
public class DeptProvide8003_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvide8003_App.class, args);
	}

}
