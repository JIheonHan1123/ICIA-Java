package com.icia.big.sample1;

// 필드(객체에 소속된 변수)는 자동으로 0으로 초기화된다.
// 클래스의 멤버: 생성자(constructor), 필드, 메소드
class 사람 {
	int height;
	int weight;
}

public class Ex3_Object {
	public static void main(String[] args) {
		사람 obj = new 사람();
		System.out.println(obj.height); // 필드는 자동으로 0으로 초기화
		obj.height = 185;
		System.out.println(obj.height);
		obj.height = 165;
		System.out.println(obj.height);
		// 사람의 키가 이렇게 바뀌는건 말이 안 됨.
		// 설계도에서부터 설계를 잘 해야한다.
	}
}
