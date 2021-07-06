package com.mvcboot.springboot.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mvcboot.springboot.model.vo.Member;

@Mapper
public interface MemberMapperInterface {
	//method를 하나의 쿼리문이 된다.
	//select update delete insert
	
	@Select("SELECT * FROM MEMBER")
	public List<Member> selectMemberAll(String id);
	
	@Select("SELECT * FROM MEMBER where USERID = #{id}")
	public Member selectfirst(String id);
	
}
