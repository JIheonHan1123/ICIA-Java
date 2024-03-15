package com.icia.b.feb02;

class Ex1 {
	// 안녕하세요.라고 인사하는 함수
	public void insa() {
		System.out.println("안녕하세요.");
	}

	public void insa(String name) {
		System.out.println(name + "입니다.");
	}

	public void sum(int val1, int val2) {
		System.out.println(val1 + val2);
	}

	public void sub(int val1, int val2) {
		System.out.println(val1 - val2);
	}

	public void mul(int val1, int val2) {
		System.out.println(val1 * val2);
	}

	public void div(int val1, int val2) {
		System.out.println(val1 / val2);
	}
}

public class Ex1_Class {
	public static void main(String[] args) {
		// 객체 생성
		// 객체 = 클래스의 변수
		Ex1 ex1 = new Ex1();
		ex1.insa();

		// 홍길동입니다
		ex1.insa("홍길동");
		ex1.insa("전우치");

		// 8
		ex1.sum(3, 5);
		// -2
		ex1.sub(3, 5);
		// 15
		ex1.mul(3, 5);
		// 0
		ex1.div(3, 5);
	}
}
