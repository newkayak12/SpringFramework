package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDaoInterface;
import com.kh.spring.member.model.vo.Member;

@Service
public class MemberService implements MemberServiceInterface{
	
	@Autowired
	MemberDaoInterface dao;

	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int enroll(Member m) {
		
		return dao.enroll(m,session);
	}

	@Override
	public Member login(Member m) {
		// TODO Auto-generated method stub
		return dao.login(m, session);
	}
	
	

}
