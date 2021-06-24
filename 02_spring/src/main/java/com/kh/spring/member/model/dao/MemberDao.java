package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDao implements MemberDaoInterface{

	@Override
	public int enroll(Member m, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.insert("member.enroll", m);
	}

	@Override
	public Member login(Member m, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("member.login", m);
	}

}
