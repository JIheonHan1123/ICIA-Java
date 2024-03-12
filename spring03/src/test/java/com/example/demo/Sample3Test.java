package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample1.SampleDao3;

@SpringBootTest
public class Sample3Test {
	@Autowired
	private SampleDao3 sampleDao3;

	@Test
	public void test1() {
		List<Map<String, Object>> list1 = sampleDao3.findGoldAvgPerSide();
		System.out.println(list1);

		List<Map<String, Object>> list2 = sampleDao3.findGoldAvgPerLane();
		System.out.println(list2);

		Map<String, String> list3 = sampleDao3.findGoldAvgAndDamPerLane("Supporter");
		System.out.println(list3);
	}

}
