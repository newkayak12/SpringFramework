package com.mvcboot.springboot.model.dao;

import java.util.List;

import com.mvcboot.springboot.model.mapper.MemberMapperInterface;
import com.mvcboot.springboot.model.vo.Member;

public interface MemberDao {

	public List<Member> selectMemberAll(String id, MemberMapperInterface memberMapper);
	
	public Member selectOneMember(String id, MemberMapperInterface memberMapper);
}
