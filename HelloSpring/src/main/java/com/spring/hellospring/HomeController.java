package com.spring.hellospring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hellospring.config.Student;
import com.spring.hellospring.model.vo.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
//	등록되어 있는 id가 emp인 애를 여기에 집어 넣는다. >> qualifier로 잡을 수 도 있다.
	private Employee emp;
//	타입 기준으로 autoWired / beans:beans의 id로 매칭하기도 한다. 
	
	
	@Autowired(required = false)
	private Student s;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println(s);
		System.out.println(emp);
		return "home";
	}
	
}
