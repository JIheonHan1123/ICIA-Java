package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample1.SampleDao4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Sample4Test {
	@Autowired
	private SampleDao4 sampleDao4;

	// @Test
	public void findCountByDeptnoTest() {
		assertTrue(sampleDao4.findCountByDeptno().size() > 0);
		List<Map<String, Object>> list = sampleDao4.findCountByDeptno();
		for (Map<String, Object> m : list) {
			log.info("{}", m);
		}
	}

	// @Test
	public void findGoldByLaneTest() {
		assertTrue(sampleDao4.findGoldByLane(17L).size() > 0);
		sampleDao4.findGoldByLane(17L).forEach(a -> log.info("{}", a));
	}

	// @Test
	public void findDpsTest() {
		assertTrue(sampleDao4.findDps(17L).size() > 0);
		sampleDao4.findDps(17L).forEach(x -> log.info("{}", x));
	}

	@Test
	public void findSKGTest() {
		assertTrue(sampleDao4.findSKG(17L).size() > 0);
		sampleDao4.findSKG(17L).forEach(y -> log.info("{}", y));
	}

}
