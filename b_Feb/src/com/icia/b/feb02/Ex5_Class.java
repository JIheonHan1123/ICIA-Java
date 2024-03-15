package com.icia.b.feb02;

// 사용가능한 상수를 정의: enum
// 함수에서 문자열일 리턴하는 것보다 enum을 사용해주는 것이 더 바람직하다
enum Result {
	우수, 합격, 불합격, 재시험;
}

class Ex5 {
	// 점수를 입력받아 70점 이상이면 합격 또는 불합격을 리턴하는 함수
	public Result score(int jumsu) {
		if (jumsu >= 70) {
			return Result.합격;
		} else {
			return Result.불합격;
		}
	}

	// 국, 영 점수 입력받아서 모두70이상=우수, 하나만70이상=합격, 아니면 재시험
	// 결과는 enum으로 출력
	public Result score(int kor, int eng) {
		if (kor >= 70 && eng >= 70) {
			return Result.합격;
		} else if (kor >= 70 || eng >= 70) {
			return Result.우수;
		} else {
			return Result.재시험;
		}
	}
}

public class Ex5_Class {
	public static void main(String[] args) {
		Ex5 ex1 = new Ex5();
		System.out.println(ex1.score(85));

		System.out.println(ex1.score(5, 50));
	}
}
