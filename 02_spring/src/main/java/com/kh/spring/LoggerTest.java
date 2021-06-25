package com.kh.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
/*
 * 
 * 로그를 출력해줄 객체를 선언하기 
 * 
 */
	private Logger log= LoggerFactory.getLogger(LoggerTest.class);
//	private org.apache.log4j.Logger l4j ;
	
	
	public static void main(String[] args) {
		new LoggerTest().loggerTest();
	}
	
	public void loggerTest() {
//		Logger에서 제공하는 각 메소드를 이용해서 로그를 출력함
//		이 친구들의 매개변수는 logger의 매개변수는 String값
		log.debug("debug log");
		log.info("info log");
		log.warn("warn log");
		log.error("error log");
	}
	
}
