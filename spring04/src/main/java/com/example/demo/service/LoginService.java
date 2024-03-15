package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;

@Service
public class LoginService {
	// appliction.properties에 만든 상수 읽어오기
	@Value("${sample3.admin.username}") // @Value는 lombok어노테이션이 아니고 스프링 어노테이션이다
	private String username;
	@Value("${sample3.admin.password}")
	private String password;

	public Boolean login(LoginDto loginDto) {
		return loginDto.getUsername().equals(username) && loginDto.getPassword().equals(password);
	}

}
