package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {//boot -->spring aaplicationContext.xml --@Configuration配置 ConfigBean = applicationContext.xml
	@Bean
	@LoadBalanced //SpringCloud Ribbon是基于Netflix Ribbon实现的一套客户端 +负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {
		//		return new RandomRule();//这一步就是替换Ribbon默认的轮询算法，改为随机算法负载
		return new RetryRule();//再试试这个算法，如果其中一台服务死了，将不再轮询那个服务

	}
}
/*@Bean
public UserService getUserService() {
	return new UserSericeImpl();
}*/
//applicationContext.xml  == ConfigBean(@Configuration)
//<bean id="uerService" class="com.atguigu.tmall.UserServiceImpl">