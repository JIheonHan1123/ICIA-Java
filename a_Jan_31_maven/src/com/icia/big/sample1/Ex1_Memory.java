package com.icia.big.sample1;

import java.util.Date;

public class Ex1_Memory {
	public static void main(String[] args) {

		// Date d; // 참조변수가 초기화 되지 않았다.
		// null: 참조변수가 초기화되지 않았다.
		Date d = null;
		// Date d = new Date();

		// NullPointerException
		// 가리키는 객체가 없는 참조변수를 사용했다
		System.out.println(d.getYear()); // d.getYear(); 참조변수 d가 가리키는 객체의 getYear()메소드 실행
	}
}
