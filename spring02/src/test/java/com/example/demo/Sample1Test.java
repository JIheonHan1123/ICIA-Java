package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample1.Dept;
import com.example.demo.sample1.DeptDao;

@SpringBootTest
public class Sample1Test {

	// 주입: wiring
	@Autowired
	private DeptDao deptDao;

	// @Test
	public void findDeptnoTest() {
		List<Long> deptno = deptDao.findDeptno();
		for (Long l : deptno) {
			System.out.println(l);
		}
	}

	// @Test
	public void findAllTest() {
		List<Dept> dept = deptDao.findAll();
		assertEquals(4, dept.size());
	}

	// @Test
	public void findByDeptnoTest() {
		Dept d1 = deptDao.findByDeptno(10L);
		assertNotNull(d1);

		// 실패도 테스트 해주는게 정확한 테스트임
		Dept d2 = deptDao.findByDeptno(70L);
		assertNotNull(d2);
	}

	@Test
	public void saveAndDeleteTest() {
		Dept d = new Dept(50L, "test", "test");
		assertEquals(1L, deptDao.save(d));

		assertEquals(1L, deptDao.delete(50L));
	}

}
