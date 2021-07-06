package com.mvcboot.springboot.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvcboot.springboot.model.service.MemberService;
import com.mvcboot.springboot.model.vo.Member;

@Controller
public class MvcController {
	@Autowired
	MemberService service;
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	
	@RequestMapping("/")
	public String main(Model m) {
		
		List<Member> list = service.selectMemberAll(null);
		List<Member> s = session.selectList("member.selectAll");
		System.out.println(s);
		m.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/selectOneMember")
	public String selectOne(Model m, String userId) {
			m.addAttribute("list",service.selectOne(userId));  
		return "searchMember";
				
	}
	
	
	
}
