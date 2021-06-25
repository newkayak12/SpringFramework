package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;

public interface DevDemoService {
	
	
	int insertDemo(Dev d);
	
	List<Dev> selectAll();
}
