package com.example.demo.controller2;

import org.springframework.web.multipart.*;

import lombok.*;

@Data
public class Sample2 {
	private String username;
	private String irum;
	private Long nai;
	private MultipartFile profile;
}
