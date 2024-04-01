package com.example.demo.controller1;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
public class ExampleController12 {
	@GetMapping("/example12/start")
	public void start() {
		
	}
	
	@PostMapping("/example12/test1")
	public ModelAndView test1(@ModelAttribute Member member) {
		log.info("{}", member);
		return null;
	}
	
	@PostMapping("/example12/test2")
	public ResponseEntity<String> test2(@ModelAttribute Member member) {
		log.info("{}", member);
		
		// 파일은 json으로 출력할 수 없다
		return ResponseEntity.ok(member.getProfile().getOriginalFilename());
	}
}
