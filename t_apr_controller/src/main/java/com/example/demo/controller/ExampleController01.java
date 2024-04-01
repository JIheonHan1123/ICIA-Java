package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// MVC 컨트롤러 : view를 지정하는 방법
// forward :  사용자 입출력을 위한 view(JSP)를 보여준다 (GET)
// redirect : 새로운 주소로 이동(Post)
// REST 컨트롤러 : Model
// front에서 location.href로 알아서 하세요
@Controller
public class ExampleController01 {
	@GetMapping("/example1/test1")
	public void test1() {
		// 리턴이 void면 url이 jsp의 이름이 된다.
		// example/test1.jsp로 forward
	}

	@GetMapping("/example1/test2")
	public String test2() { // 리턴하는 String이 jsp의 이름
		return "example1/test1";
	}

	@GetMapping("/example1/test3")
	public ModelAndView test3() {
		return new ModelAndView("example1/test1");
	}
}
