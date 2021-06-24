package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.member.model.vo.Member;

public interface MemberDaoInterface {

	public int enroll(Member m, SqlSessionTemplate session);
	
	public Member login(Member m, SqlSessionTemplate session);
}
