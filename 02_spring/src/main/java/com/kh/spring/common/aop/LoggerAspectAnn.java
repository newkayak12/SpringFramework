package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspectAnn {
//	"execution(* com.kh.spring.memo.Service..*select(..)"
//	1. pointcut등록
	@Pointcut("execution(* com.kh.spring.memo..*(..))")
	public void memoMethod() {};
	@Pointcut("execution(* com.kh.spring..*(..))")
	public void all() {};
	
	
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
		
		log.debug("=========================");
	}
	
	@Around("all()")
	public Object aroundTest(ProceedingJoinPoint join) throws Throwable{
//		ProceedingJoinPoint > 전 후를 구분해야하는데, 
//		join.proceed() 메소드 실행을 기준으로 전/후를 나눔 (proceed 실행 전이 before/ proceed 실행 후가 after)
		
			log.debug("=============== around실행 전");
		Signature sig = join.getSignature();
			log.debug(sig.getName()+" : "+sig.getDeclaringTypeName());
			log.debug("----------------");
		
		Object obj = join.proceed(); //이 위로 before ///아래로 after
		
			log.debug("================ around실행 후");
			log.debug(sig.getName()+" : "+sig.getDeclaringTypeName());
			log.debug("----------------");
		
			
			Object[] temp =join.getArgs();
			
			for(Object a : temp) {
				log.debug("log :{}",a);
			}
		return obj;
	}
	
	@Around("execution(* com.kh.spring..*Dao.*(..))")
	public Object checkRuntime(ProceedingJoinPoint join) throws Throwable{
		log.debug("===== dao performance check =====");
		StopWatch stop = new StopWatch();
		stop.start();
		
		
		Object obj = join.proceed();
		
		log.debug(" result ::");
		stop.stop();
		Signature sig = join.getSignature();
		log.debug(sig.getName()+"elapsed time : "+stop.getTotalTimeMillis()+"ms");
		
		return obj;
	}
	
	
	
	
}
