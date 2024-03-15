package com.icia.b.feb02;

class Ex4 {
	// static을 붙이면 객체없이 클래스로 바로 사용할 수 있다
	public static double 절대값(double a) {
		if (a < 0) {
			return -a;
		} else {
			return a;
		}
	} // 절대값 end

	// 정수2개를 입력받아 큰 숫자를 리턴
	public static int large(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	// 점수를 입력받아 70점 이상이면 합격 또는 불합격을 리턴하는 함수
	public static String score(int jumsu) {
		if (jumsu >= 70) {
			return "합격";
		} else {
			return "불합격";
		}
	}

}

public class Ex4_Class {
	public static void main(String[] args) {
		// 객체를 생성했다 = ex1과 ex2는 뭔가 다르다
		Ex4 ex1 = new Ex4();
		Ex4 ex2 = new Ex4();

		// 만약 항상 일정한 값이나 동작이 있다면 하나만 만들어서 공유하자
		System.out.println(Ex4.절대값(-5.5));

		// 정수2개를 입력받아 큰 숫자를 리턴
		System.out.println(Ex4.large(3, 10));

		// 점수를 입력받아 70점 이상이면 합격 또는 불합격을 리턴하는 함수
		// 85잠으로 함수를 호출해 결과 출력
		System.out.println(Ex4.score(85));

	}
}
