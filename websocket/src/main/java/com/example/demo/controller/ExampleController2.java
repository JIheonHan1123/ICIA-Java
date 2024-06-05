package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController2 {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/example2")
	public String example3() {
		return "example2";
	}

	// 클라이언트 -> 서버로 보낸 내용을 수신하는 서버측 주소
	// /to-server가 생략되어 있다 -> /to-server/chat2
	// 보내는 주소 /to-server/chat2
	// 받는 주소 /to-client/chat2
	@MessageMapping("/chat2")
	public void chat1(String message) {
		log.info("{}", message);
		messagingTemplate.convertAndSend("/to-client/chat2", message);
	}
}
