package com.icia.b.feb01;

class Clac {
	private int num1;
	private int num2;

	public Clac() {
	}

	public Clac(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public void printAdd() {
		System.out.println("덧셈: " + (num1 + num2));
	}

	public void printSub() {
		System.out.println("뺄셈: " + (num1 - num2));
	}

	public void printMul() {
		System.out.println("곱셈: " + (num1 * num2));
	}

	public void printDiv() {
		System.out.println("나눗셈: " + (num1 / num2));
	}
}

//아래의 코드가 작동하도록 클래스 생성
public class Ex5_Obj_CalcTest {
	public static void main(String[] args) {
		Clac c = new Clac(20, 10);
		// 덧셈: 30
		c.printAdd();

		// 뺄셈: 10
		c.printSub();

		// 곱셈: 200
		c.printMul();

		// 나눗셈: 2
		c.printDiv();
	}
}
