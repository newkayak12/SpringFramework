package com.spring.hellospring.demo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hellospring.demo.model.dao.DevDemoDao;
import com.spring.hellospring.demo.model.vo.Dev;

@Service
public class DevDemoServiceImpl implements DevDemoService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DevDemoDao dao;
	
	@Override
	public int insertDemo(Dev d) {
		// TODO Auto-generated method stub
		
		
		return dao.insertDemo(sqlSession, d);
	}

	@Override
	public List<Dev> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll(sqlSession);
	}

}
