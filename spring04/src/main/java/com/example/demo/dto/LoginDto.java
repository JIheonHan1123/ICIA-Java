package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class LoginDto {
	private String username;
	
	private String password;
}
