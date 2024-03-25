package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LambdaTest {
// js 화살표 함수
//		function sum(a, b) { return a+b; }
//		를
//	
//		const sum=(a,b) => { return a+b; }

//	js는 함수를 인자로 전달할 수 있다
//	function sum(a, b) {return a+b: }
//	fuction 계산기(sum) {...}

	@Test
	public void test1() {
		// 1.
		// 인터페이스의 객체를 만드는 법 (SampleInterface의 객체를 만들자)
		SampleInterface a = new SampleInterface() {
			@Override
			public void aaa() {
				// 객체를 생성하는 순간에 추상메소드를 구현한다
			}
		};

		// 2.
		// Lambda는 인터페이스의 객체를 간결하게 만드는 방법
		SampleInterface b = () -> {
			System.out.println("람다를 이용한 객체");
		};
		b.aaa();

		SampleInterface c = () -> System.out.println("코드가 한줄이면 중괄호 생략");
		c.aaa();

		// 3. 이름뒤에 s붙은 클래스 -> 작업을 간단하게 해주는 클래스들
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		// 이렇게 간단하게 표현가능
		List<Integer> list2 = Arrays.asList(10, 20, 30);
	}
}
