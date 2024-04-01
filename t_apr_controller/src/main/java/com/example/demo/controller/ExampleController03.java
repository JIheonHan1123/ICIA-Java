package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//RedirectAtttribute : redirect할 때 주소창을 사용하지 않고 값을 전달
@Controller
public class ExampleController03 {
	@GetMapping("/example3/test1")
	public void test1(Model model) {
		// 리턴이 void인 컨트롤러는 redirect가 불가능
	}

	@GetMapping("/example3/test2")
	public String test2(Model model, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "String 리턴 타입 리다이렉트");
		return "redirect:/example3/test1";
	}

	@GetMapping("/example3/test3")
	public ModelAndView test3(RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "String 리턴 타입 리다이렉트");
		return new ModelAndView("redirect:/example3/test1");
	}
}
