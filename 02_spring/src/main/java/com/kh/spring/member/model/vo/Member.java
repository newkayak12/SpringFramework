package com.kh.spring.member.model.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component

public class Member {
	private String userid, password, username;
	private String gender;
	private int age;
	private String email, phone, address;
	private String[] hobby;
	private Date enrolldate;

}
