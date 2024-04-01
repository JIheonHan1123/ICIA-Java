package com.example.demo.controller1;

import org.springframework.web.multipart.*;

import lombok.*;

@Data
public class Member {
	private String username;
	private MultipartFile profile;
}
