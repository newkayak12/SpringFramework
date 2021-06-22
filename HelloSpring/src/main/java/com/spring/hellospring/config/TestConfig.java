package com.spring.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.hellospring.model.vo.Department;
import com.spring.hellospring.model.vo.Employee;

@Configuration
//servlet-context.xml의 역할을 한다.

public class TestConfig {

	
	@Bean //Spring Context에서 활용하는 Bean이 된다. 
	public Employee getEmp() { //메소드 명이 id값이 된다. 
		
		return new Employee();
	}
	
	@Bean 
	public Department getDept() {
		Department d = new Department();
		d.setDeptCount(50);
		d.setDeptName("D6");
		
		return d;
	}
}
