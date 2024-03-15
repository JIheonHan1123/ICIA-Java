package com.icia.b.feb02;

class Ex2 {
	public int sum(int val1, int val2) {
		return val1 + val2;
	}

	public int sub(int val1, int val2) {
		return val1 - val2;
	}

	public int mul(int val1, int val2) {
		return val1 * val2;
	}

	public int div(int val1, int val2) {
		return val1 / val2;
	}
}

public class Ex2_Class_Clac {
	public static void main(String[] args) {
		Ex2 ex2 = new Ex2();

		// 8
		int sumResult = ex2.sum(3, 5);
		System.out.println(sumResult);

		// -2
		int subResult = ex2.sub(3, 5);
		System.out.println(subResult);

		// 15
		int mulResult = ex2.mul(3, 5);
		System.out.println(mulResult);

		// 0
		int divResult = ex2.div(3, 5);
		System.out.println(divResult);
	}
}
