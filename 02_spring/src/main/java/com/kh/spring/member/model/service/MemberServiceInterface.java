package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberServiceInterface {
	public int enroll(Member m);
	
	public Member login(Member m);
}
