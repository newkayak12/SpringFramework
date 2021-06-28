package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspectAnn {
//	"execution(* com.kh.spring.memo.Service..*select(..)"
//	1. pointcut등록
	@Pointcut("execution(* com.kh.spring.memo..*(..))")
	public void memoMethod() {};
	
//	2. advisor등록
	@Before("memoMethod()")
	public void loggerTest(JoinPoint jp) {
		Signature sig = jp.getSignature();
		log.debug("========== annotaion AOP ==========");
		log.debug("start");
		log.debug(sig.getName()+" : "+sig.getDeclaringTypeName());
		
		log.debug("===================================");
	}
	
	
	@After("memoMethod()")
	public void loggerTestAfter(JoinPoint jp) {
		Signature sig = jp.getSignature();
		
		log.debug("==========after==========");
		log.debug(sig.getName()+" : "+sig.getDeclaringTypeName());
		
		log.debug("===================================");
	}
	
}
