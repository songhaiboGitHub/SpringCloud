package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//EurekaServer允许其他服务向上注册
public class Config_Git_EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Config_Git_EurekaServerApplication.class, args);

	}

}
