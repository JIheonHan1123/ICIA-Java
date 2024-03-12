package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample1.SampleDao;

@SpringBootTest
class Spring03ApplicationTests {
	@Autowired
	private SampleDao sampleDao;

	// @Test
	public void findJobTest() {
		sampleDao.findJob();
	}

	// 결과가 1개인 경우에 -> 결과가 없으면 null
	// 결과가 여러개 -> 없어도 List가 null이 아니라 그냥 비어있는 리스트 (size가 0)
	// @Test
	public void findLaneTest() {
		assertEquals(5, sampleDao.findLane().size());
	}

	// @Test
	public void mapTest() {
		Map<String, String> map1 = new HashMap<>();
		// Map<데이터의 이름, 값>
		// 값의 타입을 모를 때는 Map<String, Object> 해주면 됨 -> object에는 아무 타입이나 다 들어가자나~
		map1.put("irum", "홍길동");
		map1.put("school", "학익고");
		System.out.println(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("irum", "홍길동");
		map2.put("age", 20);
		System.out.println(map2);
	}

	// @Test
	public void findAll1Test() {
		List<Map<String, Object>> list = sampleDao.findAll1();
		for (Map<String, Object> m : list) {
//			System.out.println(m.get("deptno"));
			System.out.println(m.get("DEPTNO")); // 대문자로 적어줘야 함
		}
	}

	// @Test
	public void countTest() {
		Map<String, Object> map = sampleDao.count();
		System.out.println(map);
	}

	@Test
	public void calcMandMTest() {
		Map<String, Object> map = sampleDao.calcMandM();
		System.out.println(map);
	}
}
