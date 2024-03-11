package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.sample03.NewCar;

// 스프링을 실행한 다음 테스트 돌려라
@SpringBootTest
public class Sample03Test {
	@Autowired
	NewCar car;

	@Test
	public void test1() {
		car.drive();
	}
}
