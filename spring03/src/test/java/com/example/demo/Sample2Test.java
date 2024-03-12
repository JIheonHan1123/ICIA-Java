package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample1.SampleDao2;

@SpringBootTest
public class Sample2Test {
	@Autowired
	private SampleDao2 sampleDao2;

	// @Test
	public void test1() {
		System.out.println(sampleDao2.findByDeptno1(10L));
		System.out.println(sampleDao2.findByDeptno2(10L));
	}

	// @Test
	public void positonTest() {
		List<Map<String, Object>> list = sampleDao2.findByPosition("부장");
		for (Map<String, Object> p : list) {
			System.out.println(p.get("NAME"));
		}
	}

	// @Test
	public void findByDeptnoAndJobTest() {
		List<Map<String, Object>> list = sampleDao2.findByDeptnoAndJob(20L, "ANALYST");
//		assertTrue(list.size() > 0);
		for (Map<String, Object> p : list) {
			System.out.println(p);
		}
	}

	@Test
	public void findByJikwiAndBuseoTest() {
		List<Map<String, Object>> list = sampleDao2.findByJikwiAndBuseo("사원", "홍보부");
		for (Map<String, Object> p : list) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCityTest() {
		List<Map<String, Object>> list = sampleDao2.findByCity("서울", "부산");
		for (Map<String, Object> p : list) {
			System.out.println(p);
		}
	}

}
