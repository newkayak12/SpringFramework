package com.kh.spring.member.controller;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.member.model.service.MemberServiceInterface;
import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("loginmember")
@Slf4j

//@ResponsBody : 이 컨트롤러를 통으로 ajax로 쓸 수 있다. 
public class MemberController {
	
	
//	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberServiceInterface service;
//	암호화
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("/member/memberEnroll.do")
	public String enrolldispatcher() {
		return "member/enroll";
	}
	
	@RequestMapping("/member/memberenroll.fin")
	public String enroll(String userId, String password, String userName, int age, String email, String phone, String address, String gender, String[] hobby, Model model) {
//		혹은 commander로 (Member m)이렇게 해도 상관 없죠?
		
		
//		BCryptPasswordEncoder객체를 이용해서 문자열을 단방향 암호화하기
//		encode(암호화값) 메소드 이용하면 됨
		log.debug("before {}", password);
		password= pwEncoder.encode(password);
		log.debug("after {}", password);
		Member m = Member.builder().userid(userId).password(password).username(userName).age(age).phone(phone).email(email).address(address).hobby(hobby).gender(gender).build();
		log.debug("obeject {}", m);
		
		
		
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
		//비교를위한 메소드를 만들어 뒀다. 
//		matches(암호화된 값, 지금 입력 받은 원본 값) .. 복호화시키는 게 아니라 같은 방식으로 암호화된게 맞냐 아니냐를 받아내는것 ; t/f로 반환
		
		
		log.debug(password);
		
		
		
		Member m = service.login(Member.builder().userid(userid).password(password).build());
		
		if(m!=null&&pwEncoder.matches(password, m.getPassword())) {
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
	
	
	
//	기본 ajax 응답하기!
	@RequestMapping("/member/checkUserId.do")
	public void checkUserId(String userId, Writer writer)  throws Exception{
		log.info(userId);
		Member m = new Member();
		m.setUserid(userId);
		m = service.login(m);
		
		
		
		
//		writer.append(m!=null?"false":"true");
//		writer
		
		new Gson().toJson(m,writer);
//		Gson
		
	}
	
//		beanNameResolver로 실행시켜서 응답하는?
//		JsonView를 통한 ajax 처리 == return 값은 무조건 ModelAndView 설
	@RequestMapping("/member/checkIdJsonView.do")
	public ModelAndView checkIdJsonView(ModelAndView mv, String userId) {
		Member m = new Member();
		m.setUserid(userId);
		
		m=service.login(m);
		
		mv.addObject("isAble", m!=null?false:true);
		mv.addObject("su",20);
		mv.addObject("name","김태희");
		mv.addObject("spe", m);
		
		
		//viewName 세팅시 등록한 JsonView의 이름으로 설정해야한다.
		mv.setViewName("jsonView");
//		얘가 <beans:bean id="jsonView" class="net.sf.json.spring.web.servlet.view.JsonView"/>를 찾아서 
//		이 객체를 실행시킨다.
		
		return mv;
	}
	
//	Ajax를 ResponseBody로 처리하기
//	0.jackson databind 라이브러리를 받아온다. 
//	1.beanConfiguration.xml에서 jackson클래스를 converter로 등록해준다. 
//	2. 매핑된 메소드에 Responsebody 어노테이션 표시를 한다.
//	3. 원하는 데이터를 return값으로 설정한다. 
//	4. 끝 
	@RequestMapping("/member/checkIdResponseBody.do")
	@ResponseBody
//	public Member responseBody(String userId) {
//	public List<Board> responseBody(){
	public HashMap responseBody(String userId) {
		
		HashMap test = new HashMap();
		Member m = new Member();
		test.put("m", m);
//		m.setUserid(userId);
		
		List<Board> list = boardService.boardlist(1,20);
		test.put("list", list);

//		return service.login(m);
		
		return test;
		
	}
}
