package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

// 서블릿에 해당하는 클래스가 스프링의 컨트롤러
// extends HttpServlet을 해야 톰캣이 서블릿인걸 알아본다. -> 그래야 서블릿인것을 안다. 
// 스프링은 상속 대신 어노테이션을 사용한다. 
@Controller
public class SampleController1 {
	// 이름은 알아서 정하지만 어노테이션은 꼭 붙여야 한다.

	@GetMapping("/example1")
	public ModelAndView example1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1");
		return mav;
	}

	@GetMapping("/example2")
	public ModelAndView example2() {
		ModelAndView mav = new ModelAndView("example2");
		return mav;
	}

	@GetMapping("/example2_1")
	public ModelAndView example2_1() {
		ModelAndView mov = new ModelAndView("example2_1");
		return mov;
	}

	@GetMapping("/example3")
	public ModelAndView example3() {
		ModelAndView mov = new ModelAndView("example3");
		mov.addObject("message", "안녕하세요").addObject("hello", "진짜 안녕");
		return mov;
	}

	// 사용자가 입력한 값 jsp로 출력하기
	// 스프링컨트롤러 메소드의 인자를 적으면 스프링이 인자를 넣어줌
	// = 객체를 스프링이 관리하고, 개발자가 필요하다고 하면 객체를 준다
	// !!!!!!!!! 의존성주입(Dependency Injection, DI) !!!!!!!!!

	// 스프링 4대 개념
	// DI: 의존성주입
	// IoC: Inversion of Control 제어의 역전(개발자가 관리하는게 아니라 스프링이 해라)
	// AOP: 관점지향프로그래밍
	// PSA: Portable Service Abstraction
	@GetMapping("/example4")
	public ModelAndView example4(HttpServletRequest req) {
		String irum = req.getParameter("irum");
		ModelAndView mav = new ModelAndView("sample1/example4");
		mav.addObject("irum", irum);
		return mav;
	}
}
