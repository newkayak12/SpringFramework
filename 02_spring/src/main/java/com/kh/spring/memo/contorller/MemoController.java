package com.kh.spring.memo.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
public class MemoController {
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	MemoService service;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memoForward(ModelAndView mv) {
		
		
		mv.addObject("list",service.listMemo());
		mv.setViewName("memo/memo");
		
		return mv;
	}
	
	
	
	
	@RequestMapping("/memo/insert.do")
	public String insertMemo(Memo memo, Model model) {
		
		memo.setPassword(encoder.encode((String)memo.getPassword()));
		int result = service.insertMemo(memo);
		log.debug("result :{}"+result);
		
		
		
		return "redirect:/memo/memo.do";
	}
	
	@RequestMapping("/memo/delete.do")
	public String deleteMemo(String no, String pw, Model model) {
		System.out.println(no+":"+pw);
		String password = service.selectPw(Integer.parseInt(no));
			log.debug(pw);
			log.debug(password);
			model.addAttribute("loc", "memo/memo.do");	
				if(encoder.matches(pw, password)) {
					int result = service.deleteMemo(Integer.parseInt(no));
					model.addAttribute("msg", "삭제 성공");	
				} else {
					model.addAttribute("msg", "삭제 실패");	
				}
		
		
		return "common/message";
	}
}
