package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;


@Repository
public class DevDemoDaoImpl  implements DevDemoDao{

	@Override
	public int insertDemo(SqlSessionTemplate session, Dev dev) {
		// TODO Auto-generated method stub
		return session.insert("devmapper.insert",dev);
	}

	@Override
	public List<Dev> selectAll(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("devmapper.selectlists");
	}

}
