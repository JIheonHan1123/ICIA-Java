package com.icia.b.feb02;

class Ex3 {
	public int sum(int x, int y) {
		return x + y;
	}

	public int sum(int x, int y, int z) {
		return x + y + z;
	}

	// 적정체중
	public int bmi(int height) {
		return height - 105;
	}

	public double bmi(double height) {
		return height - 105;
	}
}

public class Ex3_Class_Clac {
	public static void main(String[] args) {
		Ex3 ex3 = new Ex3();

		int result1 = ex3.sum(3, 5);
//		System.out.println(result1);

		int result2 = ex3.sum(3, 4, 5);
//		System.out.println(result2);

		// 적정체중은 키-105라고 가정. 적정체중을 리턴하는 함수
		Ex3 ex4 = new Ex3();
		int garaBmi = ex4.bmi(175); // 70
		System.out.println(garaBmi);

		// 적정체중은 키-105라고 가정. 적정체중을 리턴하는 함수
		// 키는 double형
		double garaBmi2 = ex4.bmi(175.0);
		System.out.println(garaBmi2);
	}
}
