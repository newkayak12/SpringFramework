package com.kh.spring.common.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoginCheck {
	@Before("execution(* com.kh.spring.memo..*(..))")
	public void logincheck(JoinPoint join) {
		
		
		
		Signature sig = join.getSignature();
		log.debug("------- LoginCheck! -------");
		log.debug(sig.getName()+":"+sig.getDeclaringTypeName());
		Object[]a = join.getArgs();
		
//		세션을 어케 확인하니?
		
		HttpSession session = (HttpSession)RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
		
		Member loginmember = (Member) session.getAttribute("loginmember");
		
				if(loginmember ==null) {
//					aop로직 중단
//					exception으로 예외 발생 
					try {
						throw new Exception("접속 권한이 없습니다...");
					} catch(Exception e) {
						throw new RuntimeException(e.getMessage());
					}
					
					
				}
	}
 
}
