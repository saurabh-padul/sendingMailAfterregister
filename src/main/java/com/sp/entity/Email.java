package com.sp.entity;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data

//@Profile(value = { "com.mail.*" })
@Component
public class Email {

	private String to;
	public static String subject="registration in saurabh it";
	public static String message="thanks for register in saurabh it ";
	
	public Email(String s) {
		
	}
	public Email() {
		
	}
}
