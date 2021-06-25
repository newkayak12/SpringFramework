package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.demo.model.vo.Dev;

public interface DevDemoDao {
	int insertDemo(SqlSessionTemplate session, Dev dev);
	
	List<Dev> selectAll(SqlSessionTemplate Session);

}
