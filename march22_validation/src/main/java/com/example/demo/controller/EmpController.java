package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Emp;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@Validated // 스프링검증 활성화: 이걸 적으면 spring 검증, 안적으면 자바검증 cf) 자바검증이면 메소드마다 작성해야되는 몇줄의 코드가 있음
@Controller
public class EmpController {
//	@Autowired
//	private EmpService service;

	// 검증 -> 오류가 발생할 경우 이동할 루트 페이지
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	// 검증을 수행하는 메소드
	@GetMapping("/save")
	public ModelAndView save(@ModelAttribute @Valid Emp emp, BindingResult bindingResult) {
		// @ModelAttribute: 사용자 요청을 분석해 command객체를 만들어라
//				cf)command는 명령이라는 뜻이 아니라 디자인 패턴중 하나
//				ex)사용자 요청을 분석해 Emp를 만들어라
		// @Valid: 검증을 수행해라
		// BindingResult: 검증실패메세지를 담는 객체

		return new ModelAndView("redircet:/");
	}

	// 예외를 처리하는 컨트롤러
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView cvExceptionHandler(ConstraintViolationException e, RedirectAttributes ra) {
		// @ExceptionHandler는 필요한 경우 예외를 인자로 받아올 수 있다. 보통 검증할 때 쓰는 어노테이션
		// RedirectAttribute: redirect할 때 메시지 전달 (화면을 이동시키는데 주소창 이용하지 않는 것)

		// 여러개의 예외 메시지 중에 첫번째를 꺼낸다 -> optional로 나온다
		// getMessage(): 예외가 발생한 이유
		String message = e.getConstraintViolations().stream().findFirst().get().getMessage();

		// return new ModelAndView("redirect:/").addObject("message", message);
		// addObject로 하면 에러 메시지가 주소창에 뜬다
		ra.addFlashAttribute("message", message);
		return new ModelAndView("redirect:/");
	}

}
