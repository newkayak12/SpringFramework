package com.kh.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoInterceptor extends HandlerInterceptorAdapter{

	
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			// TODO Auto-generated method stub
			
			Member loginMember = (Member)request.getSession().getAttribute("loginmember");
			
				if(loginMember== null) {
					request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
					request.setAttribute("loc", "/");
					request.getRequestDispatcher("/WEB-INF/views/common/message.jsp").forward(request, response);
					
					return false;
				} else {
					return super.preHandle(request, response, handler);
				}
		}
}
