package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	@Value("${spring04.admin.username}")
	private String USERNAME;
	@Value("${spring04.admin.password}")
	private String PASSWORD;

	// Get: 화면. 서버 정보를 변경하지 않는 작업
	// Post: 처리. 서버 정보를 변경하는 작업
	// => Login: Get, Post 하나씩, Logout: Post

	// 컨트롤러 메소드의 리턴이 void면 view만 있는 거임. -> 화면만 출력하는 컨트롤러
	// 컨트롤러 메소드의 리턴이 void면 jsp의 주소는 url과 같다 (뷰의 이름과 주소가 동일)
	// 컨트롤러 메소드의 리턴이 ModelAndView면 뭔가 할 거라는 뜻.
	@GetMapping("/member/login")
	public void login() {
	}

	// 서버의 사용자 정보를 저장하는 방법
	// request: 하나의 작업 동안 저장
	// session: 로그아웃할 때까지 저장(엄밀히 말하면 이게 아닌데 쉽게 이해하기 위해 이렇게 설명)
//					  -> 세션은 쉽게 털릴 수 있다.
//					  ->세션 번호의 계속적인 변경 등 작업이 필요
//					  -> 세션이 필요한 경우? => 사용자 정보를 저장해둘 때
	// DB: 삭제할 때 까지 저장

	@PostMapping("/member/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		// spring, 1234면 로그인 된다고 가정
		if (username.equals(USERNAME) && password.equals(PASSWORD)) {
			// 로그인 성공시 세션이 아이디 저장
			session.setAttribute("username", username);
		}
		return new ModelAndView("redirect:/");
	}

//	@PostMapping("/member/login")
//	public ModelAndView login(@ModelAttribute LoginDto loginDto, HttpSession session) {
//		Boolean result = service.login(loginDto);
//		if (result) {
//			// 로그인 성공시 세션이 아이디 저장
//			session.setAttribute("username", loginDto.getUsername());
//			return new ModelAndView("redirect:/");
//		}
//		// 로그인 실패시 로그인으로 다시 이동
//		// 주소뒤에 error 이 값 어떻게 꺼내지? -> js에서 location.search로 찾는다
//		return new ModelAndView("redirect:/member/login?error");
//	}

	// 로그아웃
	@PostMapping("/member/logout")
	public ModelAndView login(HttpSession session) {
		// 세션파괴 -> 세션이 없어지잖아 -> 사용자가 세션이 없는 경우 자동으로 생성한다
		// 정리: 세션은 사용자 정보를 저장하는 곳인데
		// 세선이 생기는 것은 자동. 세션을 파괴하는 것은 수동
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}
