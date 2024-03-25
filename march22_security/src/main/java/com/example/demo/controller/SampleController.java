package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	// ex) 로그인을 했는데 로그인창에 들어가거나 회원가입창에 들어갔을 때 어떻게 처리할건지

	// @PreAuthorize, @Secured를 모두 사용하지 않으면 누구나 접근 가능
	@GetMapping("/")
	public ModelAndView 아무나접근() {
		return new ModelAndView("sample1");
	}

	// 비로그인만 접근 가능 -> 로그인을 했으면 403이 발생 -> 예외처리 해야함
	@PreAuthorize("isAnonymous()")
	@GetMapping("/login")
	public void 로그인() {
	}

	// 로그인만 접근 가능 -> 비로그인이면 로그인창으로 이동한다
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/sample3")
	public void 로그인하면접근가능() {
	}

	// 로그인한 사용자를 대상으로 권한을 검사
	@Secured("ROLE_USER")
	@GetMapping("/sample4")
	public void 유저권한만접근가능() {
	}

	@Secured("ROLE_ADMIN")
	public void 관리자만접근가능() {
	}
}
