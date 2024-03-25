package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 로그인 실패했을 때 실행되는 객체
@Component
public class MyLoginFailureHanlder extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException exception) throws IOException, ServletException {
//		HttpSession session = req.getSession();
//		session.setAttribute("msg", "로그인에 실패했습니다");
		res.sendRedirect("/member/login");
	}
}
