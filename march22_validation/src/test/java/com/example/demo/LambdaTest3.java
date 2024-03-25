package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

// 람다식을 이용해 List를 다루자: 자바 steam api
public class LambdaTest3 {
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(10, 20, 30, 100);

		// List, set 등 집합 자료형에 stream()이라는 메소드를 추가
		// stream()은 원소를 하나씩 꺼낸다

		// Consumer(): 입력은 있고, 출력은 없다
		list.stream().forEach(x -> System.out.println(x));

		// Predicate(): 입력이 있고 boolean을 리턴
		list.stream().filter(x -> x >= 70).forEach(a -> System.out.println(a));

		// java.util.Optional
		// 자바에서 객체가 null이 되는 현상은 막을 수가 없다
		// Why? boardDao.findByBno(17) -> 글이 없네? -> null ㅅㄱ
		// But! null 객체를 사용하면 에러 발생
		// => 자바8에서 null이 될 수 있는 객체는 Optional에 담아라하는 문법이 생김
		Optional<Integer> result = list.stream().filter(x -> x >= 20).findFirst();

	}
}
