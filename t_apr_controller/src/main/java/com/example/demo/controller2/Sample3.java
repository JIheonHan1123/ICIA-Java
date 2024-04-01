package com.example.demo.controller2;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Sample3 {
	private String username;
	private ArrayList<MultipartFile> profile;
}
