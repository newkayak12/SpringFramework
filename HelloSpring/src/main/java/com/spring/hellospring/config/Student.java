package com.spring.hellospring.config;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
//
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
	private String name;
	private int grade;
	private int classNum;
}
