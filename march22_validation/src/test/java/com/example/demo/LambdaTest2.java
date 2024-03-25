package com.example.demo;

import org.junit.jupiter.api.Test;

interface SampleInterface2 {
	public int calc(int a, int b);
}

public class LambdaTest2 {

	@Test
	public void test1() {
		//
		SampleInterface2 sum = (a, b) -> {
			return a + b;
		};
		System.out.println(sum.calc(10, 20));
		//

		//
		SampleInterface2 mul = (a, b) -> a * b;

	}
}
