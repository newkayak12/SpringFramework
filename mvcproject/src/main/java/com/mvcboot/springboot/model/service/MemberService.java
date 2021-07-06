package com.mvcboot.springboot.model.service;

import java.util.List;

import com.mvcboot.springboot.model.vo.Member;

public interface MemberService {
	
	public List<Member> selectMemberAll(String id);
	
	public Member selectOne(String id);

}
