package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.BoardService;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	private BoardService svc;

	@Test
	void findAllTest() {
		System.out.println(svc.findAll(1L)); // 0 1 5 6
		System.out.println(svc.findAll(6L)); // 5 6 10 11
		System.out.println(svc.findAll(11L)); // 10 11 13 0
	}

}
