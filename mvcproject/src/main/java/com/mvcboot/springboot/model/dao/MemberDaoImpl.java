package com.mvcboot.springboot.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvcboot.springboot.model.mapper.MemberMapperInterface;
import com.mvcboot.springboot.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> selectMemberAll(String id, MemberMapperInterface memberMapper) {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberAll(id);
	}

	@Override
	public Member selectOneMember(String id, MemberMapperInterface memberMapper) {
		// TODO Auto-generated method stub
		return memberMapper.selectfirst(id);
	}
	
}
