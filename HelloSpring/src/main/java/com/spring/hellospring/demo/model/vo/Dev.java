package com.spring.hellospring.demo.model.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Dev {

	private int devNo;
	private String devName;
	private int devAge;
	private String devEmail, devGender;
	private String[] devLang;
	
}
