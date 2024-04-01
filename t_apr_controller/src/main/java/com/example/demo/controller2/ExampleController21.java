package com.example.demo.controller2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController21 {
	@GetMapping("/example21/start")
	public void example1() {
	}

	// 값을 입력하지 않고 서버로 submit하면
	// 서버쪽에서 값을 꺼냈을 때 숫자의 경우에는 null이 나오고
	// 숫자가 아닌 경우에는 null이 아니라 비어있는 객체가 나온다

	@GetMapping("/example1/end")
	public ResponseEntity<Sample1> example1(Sample1 sample) {
		log.info("{}", sample.getUsername() == null);
		log.info("{}", sample.getIrum() == null);
		log.info("{}", sample.getNai() == null);
		return ResponseEntity.ok(sample);
	}
}
