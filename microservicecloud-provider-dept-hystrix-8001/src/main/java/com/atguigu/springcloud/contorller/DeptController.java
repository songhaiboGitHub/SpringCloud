package com.atguigu.springcloud.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shb.springcloud.entities.Dept;

@RestController
public class DeptController {
	@Autowired
	private DeptService dervice = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//异常后会根据HystrixCommand指定的fallbackMethod指定方法--返回指定错误信息
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = dervice.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID：" + id + "没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,null--@HystrixCommand")
				.setDb_soucre("no this database in MySQl");
	}

}
