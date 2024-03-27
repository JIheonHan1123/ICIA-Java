package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberJoinDto;
import com.example.demo.service.MemberService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@Validated // 스프링예외처리 활성화 -> RequestParam쓰면 검증이랑 안맞음 -> @NotEmpty쓰자
@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/member/login")
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}

	@PreAuthorize("isAnonymous()")
	@GetMapping("/member/join")
	public ModelAndView join() {
		return new ModelAndView("member/join");
	}

	@PreAuthorize("isAnonymous()")
	@PostMapping("/member/join")
	public ModelAndView join(@ModelAttribute @Valid MemberJoinDto dto, BindingResult br) {
		// BindingResult로 뭘 하지는 않는데 검증할 때 꼭 적어줘야함
		service.join(dto);
		return new ModelAndView("redirect:/member/login");
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView CVEHandler2(ConstraintViolationException e, RedirectAttributes ra) {
//		String msg = e.getConstraintViolations().stream().findFirst().get().getMessage();
//		return new ModelAndView("redirect:/member/join").addObject("msg", msg); // addObject로 msg띄우면 msg 주소창에 뜸 -> 안뜨게 하고싶으면 RedirectAttribute를 쓴다
		ra.addFlashAttribute("msg", "프로필 사진을 제외한 모든 값은 필수입니다");
		return new ModelAndView("redirect:/member/join");
	}
}
