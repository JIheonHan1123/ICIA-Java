package a_Jan_30;

// 제어문
// 선택: if, switch
// 반복문: for,  while, do~while
// break, continue

public class Ex1_Controll {
	public static void main(String[] args) {

		// if ex01) 90up 우수, 70up 합격, or 불합격
//		int score = 100;
//		if (score >= 90) {
//			System.out.println("우수");
//		} else if (score >= 70) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
//		

		// if ex02) 모두 70이상이면 합격, 아니면 불합격
//		int kor = 85;
//		int eng = 70;
//		if (kor >= 70 && eng >= 70) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
//		

		// if ex03) 점수 변수를 초기화하고, 점수에 따라 A,B,C,D,F 출력
		// cf) 90up A, 80up B, 70up C, 60up D, or F
//		int score = 100;
//		if (score >= 90) {
//			System.out.println("A");
//		} else if (score >= 80) {
//			System.out.println("B");
//		} else if (score >= 70) {
//			System.out.println("C");
//		} else if (score >= 60) {
//			System.out.println("D");
//		} else {
//			System.out.println("F");
//		}
//		
//		

		// for ex01) 파이썬에서 10번 반복하는 반복문: for i in range(1,11)을 자바로
		// for (카운터초기화; 반복조건; 카운터변경)
//		for (int i = 1; i <= 10; ++i) {
//			System.out.println(i);
//		}
//		

		// for ex02) for문만 사용해서 1~10사이의 홀수 출력 (1 3 5 7 9)
//		for (int i = 1; i <= 10; i = i + 2) {
//			System.out.println(i);
//		}
//		

		// for ex03) 1부터 10가지 홀수의 합계
		// ex03-1)
//		int sum1 = 0, sum2 = 0, sum3 = 0;
//		for (int i = 1; i <= 10; i = i + 2) {
//			sum1 += i;
//		}
//
//		// ex03-2)
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 == 0) {
//				continue; // continue = pass
//			}
//			sum2 += i;
//		}
//
//		// ex03-3)
//		for (int i = 1; i <= 10; i = i + 2) {
//			if (i % 2 != 0) {
//				sum3 += i;
//			}
//		}
//
//		System.out.println(sum1);
//		System.out.println(sum2);
//		System.out.println(sum3);
//		
//		

		// for ex04) 1~100사이에서 5의 배수 또는 7의 배수를 출력하시오
//		for (int i = 1; i <= 100; i++) {
//			if (i % 5 == 0 || i % 7 == 0) {
//				System.out.print(" " + i);
//			}
//		}
//

	} // main end

}
