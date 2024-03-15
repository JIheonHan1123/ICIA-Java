package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpTest {

	@Autowired
	private EmpDao empDao;

	// @Test
	public void findAllTest() {
		empDao.findAll();
	}

	@Test
	public void findByEnameTest() {
		empDao.findByEname(7369L);
	}

}
