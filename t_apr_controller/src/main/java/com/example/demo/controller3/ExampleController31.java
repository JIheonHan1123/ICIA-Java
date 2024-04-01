package com.example.demo.controller3;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController31 {
	@GetMapping("/example31/start")
	public void start() {
	}

	@PostMapping("/example31/test1")
	public ResponseEntity<ChoiceDto> start(@ModelAttribute ChoiceDto dto) {
		return ResponseEntity.ok(dto);
	}
}
