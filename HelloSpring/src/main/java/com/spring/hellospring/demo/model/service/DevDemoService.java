package com.spring.hellospring.demo.model.service;

import java.util.List;

import com.spring.hellospring.demo.model.vo.Dev;

public interface DevDemoService {
	
	
	int insertDemo(Dev d);
	
	List<Dev> selectAll();
}
