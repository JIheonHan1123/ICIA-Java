package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@GetMapping("/member/login")
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}

	// ResponseEntity: 응답데이터 + 상태코드
	@GetMapping("/member/id-check")
	public ResponseEntity<String> idCheck(@RequestParam String username) {
		// 아이디가 spring이면 사용불가능, 아니면 가능
		if (username.equals("spring")) {
			return ResponseEntity.status(409).body("사용중입니다");
		}
		return ResponseEntity.status(200).body("사용가능합니다");
	}

	@PreAuthorize("isAnonymous()")
	@GetMapping("/member/join")
	public ModelAndView join() {
		return new ModelAndView("member/join");
	}

	@PreAuthorize("isAnonymous()")
	@PostMapping("/member/join")
	public ModelAndView join(MultipartFile profile) {
		System.out.println(profile.getOriginalFilename());
		return null;
	}
}
