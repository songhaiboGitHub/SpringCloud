package com.atguigu.springcloud.service;

import java.util.List;

import com.shb.springcloud.entities.Dept;

public interface DeptService {
	/*	public boolean addDept(Dept dept);
	
		public Dept findById(Long id);
	
		public List<Dept> findAll();*/
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
