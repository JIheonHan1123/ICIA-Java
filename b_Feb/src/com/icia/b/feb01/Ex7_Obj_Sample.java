package com.icia.b.feb01;

class Sample {
	// static 필드는 하나만 존재함. 모든 객체들이 공유 => this. 사용불가
	static int count;
	// static 없으면 객체의 수 만큼 존재

	public Sample() {
		count++;
	}
}

public class Ex7_Obj_Sample {
	public static void main(String[] args) {
		// Sample 객체가 몇개나 생성되는지 알고 싶다
		Sample s1 = new Sample();
		Sample s2 = new Sample();
		Sample s3 = new Sample();

		System.out.println(s1.count);
		System.out.println(s2.count);
		System.out.println(s3.count);
		// 1, 2, 3이 나오면 좋겠지만 다 따로 놀기때문에 1, 1, 1 나온다

		// => 그래서 공유데이터를 만든다
		// 객체들이 공유하는 필드 = static
		// = 정적필드(정적 멤버) != 일반멤버(static 없는거 -> 객체를 만들어야만 사용 가능)

		// 정적멤버는 클래스이름으로 사용하자
		// 정적멤버는 객체를 만들지 않아도 접근 가능
		// => 정적멤버는 객체소속이 아니다! Why? 클래스 소속이기 때문
		System.out.println(Sample.count);
	}
}
