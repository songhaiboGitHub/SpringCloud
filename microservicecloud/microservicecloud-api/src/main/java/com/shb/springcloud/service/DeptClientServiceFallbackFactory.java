package com.shb.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.shb.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;

@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable throwable) {

		return new DeptClientService() {
			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provide已经关闭")
						.setDb_soucre("no this database in MySQL");
			}

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
