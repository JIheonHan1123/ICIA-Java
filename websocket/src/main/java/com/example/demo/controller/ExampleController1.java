package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController1 {
	// 웹소켓은 서버가 클라이언트로 메세지 보내려고 쓰는 것
	// 그 중 가장 대표적인 예시가 채팅
	// 웹소켓을 발송하는 STOMP 템플릿
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@GetMapping("/example1")
	public String example1() {
		return "example1";
	}

	// 10초마다 서버에서 클라이언트들로 메시지를 보낸다
	// 클라이언트들이 수신할 주소는 /to-client/all
	@Scheduled(fixedDelay = 10000)
	public void broadcastMessage1() {
		String message = "10초가 지났어요";
		log.info("{}", message);
		messagingTemplate.convertAndSend("/to-client/all", message);
	}

	public void scheduledTask2() {
		// 자바로 LocalDate, LocalDateTime을 문자열로 변경하기
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh시 mm분입니다");
		String message = dtf.format(LocalDateTime.now());

		messagingTemplate.convertAndSend("/to-client/all", message);
	}

}
