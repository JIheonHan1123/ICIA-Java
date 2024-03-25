package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 스프링 시큐리티는 스프링에 인수됐지만 독립적인 제품이다.
// => 스프링 시큐리티는 컨트롤러 베이스가 아니라 서블릿 베이스로 동작한다. -> 스프링 관계없이 자바에서 사용가능

// AccessDenialHandler: 403 오류를 처리를 담당하는 객체 = 권한이 없으면 403 -> 예외처리담당
@Component
public class MyAccessDenialHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//		HttpSession session = req.getSession();
//		session.setAttribute("msg", "잘못된 접근입니다");
		res.sendRedirect("/");
	}
}