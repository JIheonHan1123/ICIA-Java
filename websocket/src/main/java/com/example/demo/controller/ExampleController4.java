package com.example.demo.controller;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController4 {
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/example4")
	public String example4() {
		return "example4";
	}

	// stomp에서 로그인한 아이디는 Principal로 읽어올 수 있다
	@MessageMapping("/chat4")
	@SendTo("/to-client/chat4")
	public String chat4(String message, Principal principal) {
		System.out.println(principal.getName());
		return principal.getName() + ":" + message;
	}
}
