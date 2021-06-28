package com.kh.spring.common.aop;

import org.aspectj.lang.Signature;
import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

//AOP에 해당하는 기능을 구현한 객체
@Slf4j
public class LoggerAspect {
	
	
//	advisor등록
	
//	before advisor구현
	
	public void loggerBefore(JoinPoint jp) {
		
		Signature sig = jp.getSignature();
		log.debug("=========== aop defore applied ==========");
//	특정한 메소드가 실행되기 전에 처리하는 녀석이죠... getArgs는 그 메소드가 갖고 있는 인자...
//	패턴으로 적었는데 어떤 메소드인지 확인하고 싶잖아요?? >> 메소드 명을 확인하려 Signature
		log.debug(sig.getName()+" : "+sig.getDeclaringTypeName());
		
		log.debug("=========================================");
		
	}
}
