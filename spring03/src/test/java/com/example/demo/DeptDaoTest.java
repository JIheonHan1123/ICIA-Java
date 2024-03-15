package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.march14.DeptDao;

@SpringBootTest
public class DeptDaoTest {
	@Autowired
	private DeptDao deptDao;

	// @Test
	public void initTest() {
		assertNotNull(deptDao);
	}

	// @Test
	public void findPositionTest() {
		deptDao.findPosition();
	}

	@Test
	public void countGroupByPosition3Test() {
		deptDao.countGroupByPosition3();
	}

}
