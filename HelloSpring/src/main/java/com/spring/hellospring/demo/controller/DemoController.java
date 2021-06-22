package com.spring.hellospring.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	
	
	@RequestMapping(value="/demo/demo.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String demoPage() {
//		화면전환용으로 만들었어요
		
		
		return "demo/demo";
	}
	
	
// controller 객체의 메소드는 서블릿에서 doGet/dePost 메소드 역할을 한다.
// 프론트에서 전송되는 데이터는 Controller 메소드에서 파라미터 값으로 받는다. 
// 파라미터로 받을 수 있는 값
/*		>
 *  파라미터로 선언하면 자동으로 스프링이 대입해준다.
 *  
 *  
 *  매개변수를 선언만 하면 됨...
 *  
 *  ---------------- 매개변수로 받는 -----------------
 *  
 *  
 *   1. HttpServletRequest
 *   2. HttpServletResponse
 *   3. HttpSession
 *   4. java.util.Locale 
 *   5. inputStream / Reader 
 *   6. OutputStream / writer
 *   
 *   ========== 파라미터를 자동으로 객체로 받을 수 있음 command객체
 *   
 *   7. vo객체, map : 파라미터 값을 자동으로 대입해서 받음
 *   8. model : 데이터 공용 객체 (기본 request와 비슷)
 *   9. modelAndView : 데이터 공용 객체 및 view에 대한 정보까지 같이 저장하는 객체 (MODEL도 갖고 있고, View에 대한 정보도 같이 같고 있다.)
 *   
 *   ----------- 특정 어노테이션을 선언하여 값을 받는 매개변수 -----------------
 *   
 *   @RequestParam(value="파라미터 이름", 옵션) 변수선언
 *   @RequestHeader(value="헤더 key 값") : header의 정보를 가져오는 것
 *   @CookieValue (value="쿠키 키 값") : 변수 선언 : Cookie 값
 *   
 *   
 *   ------------------------추가 메소드 선언부에 선언하는 어노테이션 -----------------
 *   @pathValiable("값") > restful 방식으로 구현할 때 URL에 있는 데이터를 가져올 때 : 경로 안의 변수???
 *   
 *   @responseBody > 클라이언트에게 응답할 때 메소드 리턴값을 JSON형태로 변환해주는 어노테이션
 *   
 *   
 *   
 */
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("devName"));
		System.out.println(res);
		
		
		return "";
	}

}
