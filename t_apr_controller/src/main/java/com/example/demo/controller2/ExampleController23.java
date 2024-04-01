package com.example.demo.controller2;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController23 {
	@GetMapping("/example23/start")
	public void example1() {
	}

	@PostMapping("/example23/end")
	public ResponseEntity<Sample3> example1(Sample3 sample) {

		// 사진을 선택하지 않으면 null이 아니라 비어있는 MultipartFile
		List<MultipartFile> profile = sample.getProfile();
		for (MultipartFile p : profile) {
			if (p.isEmpty() == false) {
				// 비어있는 MultipartFile에 대해 getOriginalFilename()을 하면 빈문자열이 나옴
				System.out.println(p.getOriginalFilename());
			}
		}
		return null;
	}
}
