package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member { // Dao작업하는 클래스
	private String username;
	private String password;
	private String email;
	private LocalDate birthday;
	private LocalDate joinday = LocalDate.now();
	private String profile;

	private Role role = Role.USER;
}