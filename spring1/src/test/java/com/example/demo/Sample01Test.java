package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.sample01.자동차;
import com.example.demo.sample01.한국타이어;

public class Sample01Test {
	@Test
	public void test1() {
		한국타이어 tire = new 한국타이어();
		자동차 car = new 자동차(tire, null);
	}
}