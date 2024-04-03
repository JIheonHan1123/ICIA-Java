package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import com.example.demo.dto.MemberReadDto;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;
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
	@GetMapping("/member/find")
	public ModelAndView find() {
		return new ModelAndView("member/find");
	}

	@PreAuthorize("isAnonymous()")
	@PostMapping("/member/join")
	public ModelAndView join(@ModelAttribute @Valid MemberJoinDto dto, BindingResult br) {
		service.join(dto);
		return new ModelAndView("redirect:/member/login");
	}

	@Secured("ROLE_USER")
	@GetMapping("/member/check-password")
	public ModelAndView checkPassword(HttpSession session) {
		if (session.getAttribute("check") != null) {
			return new ModelAndView("redirect:/member/read");
		}
		return new ModelAndView("member/check-password");
	}

	@Secured("ROLE_USER")
	@PostMapping("/member/check-password")
	public ModelAndView checkPassword(String password, Principal principal, HttpSession session, RedirectAttributes ra) {
		Boolean result = service.checkPassword(password, principal.getName());
		if (result == true) {
			// 비밀번호를 확인하면 세션에 check 값을 true로 설정
			session.setAttribute("check", true);
			return new ModelAndView("redirect:/member/read");
		}
		ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
		return new ModelAndView("redirect:/member/check-password");
	}

	// @PreAuthorize("isAuthenticated()")
	// @Secured이 없으면 null 체크를 해야한다.
	@Secured("ROLE_USER")
	@GetMapping("/member/read")
	public ModelAndView read(Principal principal, HttpSession session) {
		// 비밀번호를 확인하면 세션에 check 값을 true로 설정
		if (session.getAttribute("check") == null) {
			return new ModelAndView("redirect:/member/check-password");
		}

		// 스프링 시큐리티 제공해주는 객체
		// Authentication : 로그인한 사용자의 모든 정보를 담은 객체
		// Principal : 로그인한 사용자의 아이디
		// 비로그인이라면 Principal은 null이 된다
		// 스프링 시큐리티가 제공하는 Principal : 로그인한 사용자의 아이디
		MemberReadDto member = service.read(principal.getName());
		return new ModelAndView("member/read").addObject("member", member);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView CVEHandler2(ConstraintViolationException e, RedirectAttributes ra) {
//		String msg = e.getConstraintViolations().stream().findFirst().get().getMessage();
//		return new ModelAndView("redirect:/member/join").addObject("msg", msg); // addObject로 msg띄우면 msg 주소창에 뜸 -> 안뜨게 하고싶으면 RedirectAttribute를 쓴다
		ra.addFlashAttribute("msg", "프로필 사진을 제외한 모든 값은 필수입니다");
		return new ModelAndView("redirect:/member/join");
	}

	@Secured("ROLE_USER")
	@PostMapping("/member/delete")
	public ModelAndView 탈퇴(Principal principal, HttpSession session) {
		// 로그아웃 후에 탈퇴(삭제)시켜야 함
		session.invalidate();
		service.delete(principal.getName());
		return new ModelAndView("redirect:/");
	}
}
