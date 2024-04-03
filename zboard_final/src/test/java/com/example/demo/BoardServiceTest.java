package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import com.example.demo.service.*;

@SpringBootTest
public class BoardServiceTest {
	@Autowired
	private BoardService service;
	
	@Test
	public void findAllTest() {
		// 0 1 5 6
		System.out.println(service.findAll(1L));
		// 5 6 10 11
		System.out.println(service.findAll(6L));
		// 10 11 13 0
		System.out.println(service.findAll(11L));
	}
}
