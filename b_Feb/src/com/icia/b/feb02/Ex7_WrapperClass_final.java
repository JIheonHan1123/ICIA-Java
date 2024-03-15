package com.icia.b.feb02;

// final: 변경금지
public class Ex7_WrapperClass_final {
	public static void main(String[] args) {
		final int a = 10;
		// a = 11; // 에러남

		// 객체를 만들었다는 건, 뭔가가 다르다는 것
		// Math math1 = new Math();
		// Math math2 = new Math();
		// 근데 수학이 다를 리가 있나? => No

		// => Math클래스도 static이다
		System.out.println(Math.PI);
		System.out.println(Math.round(3.14)); // 반올림
		System.out.println(Math.ceil(3.14)); // 올림
		System.out.println(Math.floor(3.14)); // 내림

		// wrapper 클래스는 객체 생성이 가능하긴 하다 => 하지만 하지 않는다
		Integer x = new Integer(10);

		// But, Math클래스는 객체 생성이 금지되어 있다.
		// => Math클래스는 final
	}
}
