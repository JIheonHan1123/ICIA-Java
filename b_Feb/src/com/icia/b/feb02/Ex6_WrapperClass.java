package com.icia.b.feb02;

// static의 예: Wrapper Class -> 객체를 만들 수는 있지만 보통 만들지 않는다.
public class Ex6_WrapperClass {
	public static void main(String[] args) {
		// 8개의 기본타입에 대해 각각의 클래스를 제공: static변수, 메소드
		System.out.println(Integer.SIZE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		// 문자열을 숫자로
		System.out.println(Integer.parseInt("152"));

		// 숫자를 문자로
		System.out.println(152 + "");
	}
}
