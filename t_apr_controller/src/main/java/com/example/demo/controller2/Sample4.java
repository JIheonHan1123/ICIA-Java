package com.example.demo.controller2;

import java.util.*;

import org.springframework.web.multipart.*;

import lombok.*;

@Data
public class Sample4 {
	private String username;
	private ArrayList<MultipartFile> profiles;
}
