package com.kh.spring.demo.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DevDemoService;
import com.kh.spring.demo.model.vo.Dev;

@Controller
public class DemoController  {
	@Autowired
	private DevDemoService service;
	
	
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
 *   @pathVariable("값") > restful 방식으로 구현할 때 URL에 있는 데이터를 가져올 때 : 경로 안의 변수???
 *   
 *   @responseBody > 클라이언트에게 응답할 때 메소드 리턴값을 JSON형태로 변환해주는 어노테이션
 *   
 *   
 *   
 */
	
	
	
	
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		System.out.println(req.getParameter("devName"));
		System.out.println(res);
		
		Dev dev = new Dev();
		dev.setDevName(req.getParameter("devName"));
		dev.setDevAge(Integer.parseInt(req.getParameter("devAge")));
		dev.setDevEmail(req.getParameter("devEmail"));
		dev.setDevGender(req.getParameter("devGender"));
		dev.setDevLang(req.getParameterValues("devLang"));
		
		req.setAttribute("dev", dev);
		System.out.println("세션 값 :" + session.getAttribute("userId"));
		return "demo/demoResult";
	}
	
	
	
//	@RequestParam 어노테이션 이용
//	클라이언트가 전송하는 값을 1:1로 매개변수로 바로 받을 수 있다.
	@RequestMapping("/demo/demo2.do")
//	public String demo2( 
//			
//			@RequestParam(value="devName") String devName
//			, @RequestParam(value="devAge", required = false, defaultValue = "1") int devAge
////			기본으로 required true라서 꼭 필요로 하는데, int 같은 경우는 단순히 required만으로는 안되고 defaultValue가 필요
//			, @RequestParam(value="devEmail") String devEmail
//			, @RequestParam(value="devGender", required = false) String devGender
//			, @RequestParam(value="devLang", required=false) String[] devLang, Model model
//			
//			) {
//	 원래는 이렇게 쓰는데,
	
	public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang, Model model) {
		
//		만약.... 귀찮다면 모두 required true라는 전제로! 그냥 써도 됨
		
		Dev devs = Dev.builder().devName(devName).devAge(devAge).devEmail(devEmail).devGender(devGender).devLang(devLang).build();
		
		
//		Model객체를 이용해서 서버 데이터 전송하기
//		데이터를 저장할 때 k:V로 저장
		
		model.addAttribute("dev", devs); //request와 생존 주기가 동일하다.
		return "demo/demoResult";
		
	}
	
	
	
//	Command객체로 파라미터 값 받아오기
//	command 객체로 지정된 객체의 멤버 변수 파라미터의 key값이 일치해야한다.
//	매핑을 위해서!
//	default생성자로 생성 후, setter로 값을 대입 >>  메소드 명명규칙을 준수해야한다. 
	
	@RequestMapping("/demo/demo3.do")
	public String demo3(Dev dev, Model model) {
//		Command를 쓸 때 자료형
//		기본 자료형을 제외한 자료형이 있으면 대입이 제한(DATE 같은 경우)
		
		model.addAttribute("dev", dev);
		return "demo/demoResult";
	}
	
	
	@RequestMapping("/demo/demo4.do")
	public String demo4(@RequestParam Map map, String[] devLang, Model model) {
		map.put("devLang", devLang);
		
		model.addAttribute("dev",map);
		return "demo/demoResult";
	}
	
//	추가 데이터 매개변수로 받기 header, cookie
	@RequestMapping("/demo/demo5.do")
	public String demo5(@RequestHeader(value="User-Agent") String userAgent, @RequestHeader(value="Referer") String prePage, @CookieValue(value="choco", required=false) Cookie jar) {
		
		System.out.println(userAgent);
		System.out.println(prePage);
		System.out.println(jar.getValue());
		
//		만약 해당하는 쿠기가 없으면???????????????
//		badRequest(400)
//		required false를 넣으면 null로 
		
		return "demo/demo";
	}
	
	@RequestMapping(value="/demo/insertdev.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String insert(Dev dev, Model m) {
		
		int result = service.insertDemo(dev);
		System.out.println(result);
		
		return "demo/demo";
	}
	
	@RequestMapping("/demo/demoList.do")
	public String select (Model model) {
		
		
		model.addAttribute("list", service.selectAll());
		
		
		
		return "demo/demoview";
	}
	
	

}
