package com.mvcboot.springboot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcboot.springboot.model.dao.MemberDao;
import com.mvcboot.springboot.model.mapper.MemberMapperInterface;
import com.mvcboot.springboot.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapperInterface memberMapper;
	
	@Autowired
	MemberDao dao;
	
	@Override
	public List<Member> selectMemberAll(String id) {
		// TODO Auto-generated method stub
		return dao.selectMemberAll(id, memberMapper);
	}

	@Override
	public Member selectOne(String id) {
		// TODO Auto-generated method stub
		return dao.selectOneMember(id, memberMapper);
	}

}
