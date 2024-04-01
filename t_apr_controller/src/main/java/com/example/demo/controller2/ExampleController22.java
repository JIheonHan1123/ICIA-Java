package com.example.demo.controller2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController22 {
	@GetMapping("/example22/start")
	public void example1() {
	}

	// username, irum, nai, profile
	// 숫자를 제외하고 값을 입력하지 않으면 비어있다
	// null이 나오려면 name이 존재하지 않아야 한다
	@PostMapping("/example22/end")
	public ResponseEntity<Sample2> example1(MultipartFile profile, MultipartFile sajin) {
		log.info("{}", profile == null); // false
		log.info("{}", sajin == null); // true

		// 파일을 업로드하지 않았다
		log.info("{}", profile.isEmpty());
		return null;
	}
}
