package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleController2 {
	// 화면을 보여준다
	@GetMapping("/sample2/add")
	public ModelAndView add() {
		return new ModelAndView("sample2/add");
	}

	// 두개의 값을 받아서 출력
	@PostMapping("/sample2/add")
	public ModelAndView add(HttpServletRequest req) {
		Long a = Long.parseLong(req.getParameter("val1"));
		Long b = Long.parseLong(req.getParameter("val2"));
		Long result = a + b;
		ModelAndView mav = new ModelAndView("sample2/result");
		return mav.addObject("result", result);
	}

	// 이름, 나이받는 예제
	@GetMapping("/sample3/input")
	public ModelAndView input() {
		return new ModelAndView("sample3/input");
	}

	@PostMapping("/sample3/input")
	public ModelAndView input(HttpServletRequest req) {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		ModelAndView mav = new ModelAndView("sample3/output");
		mav.addObject("name", name);
		mav.addObject("age", age);
		return mav;
	}

}
