package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.member.model.service.MemberServiceInterface;
import com.kh.spring.member.model.vo.Member;

@Controller
@SessionAttributes("loginmember")
public class MemberController {
	
	@Autowired
	private MemberServiceInterface service;

	@RequestMapping("/member/memberEnroll.do")
	public String enrolldispatcher() {
		return "member/enroll";
	}
	
	@RequestMapping("/member/memberenroll.fin")
	public String enroll(String userId, String password, String userName, int age, String email, String phone, String address, String gender, String[] hobby, Model model) {
//		혹은 commander로 (Member m)이렇게 해도 상관 없죠?
		
		Member m = Member.builder().userid(userId).password(password).username(userName).age(age).phone(phone).email(email).address(address).hobby(hobby).gender(gender).build();
			
			int result = service.enroll(m);
		
					if(result>0) {
						model.addAttribute("msg", "가입 성공");
					} else {
						model.addAttribute("msg", "가입 실패");
					}
				model.addAttribute("loc", "index.jsp");
		return "common/message";
	}
	
//	로그인 로직
//	@RequestMapping("/member/memberlogin.do")
//	public String login(String userid, String password, HttpSession session, Model model) {
//		
//		Member m = service.login(Member.builder().userid(userid).password(password).build());
//		System.out.println(m);
//		if(m!=null) {
//			session.setAttribute("loginmember", m);
////			로그인에 대한 정보를 session 객체를 이용해서 처리하지 않고 model객체를 이용할 수도 있음
////			@SessionAttributes 어노테이션을 이용한다.
//			/*
//			 * 
//			 * @SessionAttributes(model의 키 값)
//			 */
//			
//			model.addAttribute("msg","로그인성공");
//
//		} else {
//			model.addAttribute("msg","아이디나 비밀번호가 틀렸습니다.");
//			
//		}
//		model.addAttribute("loc","index.jsp");
//		
//		return "common/message";
//	}
	
	@RequestMapping("/member/memberlogin.do")
	public String login(String userid, String password,  Model model) {
		
		Member m = service.login(Member.builder().userid(userid).password(password).build());
		System.out.println(m);
		if(m!=null) {
//			session.setAttribute("loginmember", m);
//			로그인에 대한 정보를 session 객체를 이용해서 처리하지 않고 model객체를 이용할 수도 있음
//			@SessionAttributes 어노테이션을 이용한다.
			/*
			 * 
			 * @SessionAttributes(model의 키 값)
			 */
			model.addAttribute("loginmember",m);
			model.addAttribute("msg","로그인성공");

		} else {
			model.addAttribute("msg","아이디나 비밀번호가 틀렸습니다.");
			
		}
		model.addAttribute("loc","index.jsp");
		
		return "common/message";
	}
	
	
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session, SessionStatus ss) {
		if(session!=null) {
			session.invalidate();
			//Model과 Session은 다르다. 
//			model에서 추가한 객체를 sessionStatus객체를 이용해서 관리
		}
		
		
		if(!ss.isComplete()) {
			ss.setComplete();
		}
		
		
//		logout후에 redirect로 전송을 해야곘죠
//		redirect:주소
		return "redirect:/";
	}
}
