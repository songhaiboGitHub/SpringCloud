package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
//        return new RandomRule();//这一步就是替换Ribbon默认的轮询算法，改为随机算法负载
		
		/**
		 * 依旧轮询策略，加上新需求，每台服务器调用5次。以前是每台服务器访问一次
		 */
        return new RandomRule_ZY();//自定义负载均衡算法，每台服务其访问5次，就切下一台
	}
}
