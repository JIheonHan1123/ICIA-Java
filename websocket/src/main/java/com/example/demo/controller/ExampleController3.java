package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExampleController3 {
	@GetMapping("/example3")
	public String example3() {
		return "example3";
	}

	@MessageMapping("/chat3")
	@SendTo("/to-client/chat3")
	public String chat3(String message) {
		return message;
	}
}
