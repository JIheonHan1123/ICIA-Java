package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class ExampleController02 {
	@GetMapping("/example2/test1")
	public void test1(Model model) {
		model.addAttribute("msg", "model 객체를 이용해 전달했습니다");
	}
	
	@GetMapping("/example2/test2")
	public String test2(Model model) {
		model.addAttribute("msg", "model 객체를 이용해 전달했습니다");
		return "example2/test1";
	}
	
	@GetMapping("/example2/test3")
	public ModelAndView test3() {
		return new ModelAndView("example2/test1").addObject("msg", "ModelAndView를 이용해 전달했습니다");
	}
}
