package a_Jan_30;

// 자바에서도 리스트를 가지고 반복문 연습
// 자바에서 같은 타입의 집합을 배열이라고 한다. 배열자체는 중요X

public class Ex2_Controll_List {
	public static void main(String[] args) {

		// 파이썬: ar = [10,20,30,40,50]
//		int[] ar = { 10, 20, 30, 40, 50 };
//
//		for (int i = 0; i < 5; i++) {
//			System.out.println(ar[i]);
//		}
//		

		// ex01) 다음 배열의 원소 중 짝수를 출력
//		int[] br = { 35, 27, 40, 26, 80 };
//		for (int i = 0; i < 5; i++) {
//			if (br[i] % 2 == 0) {
//				System.out.println(br[i]);
//			}
//		}
//		

		// ex02) 다음 배열에서
		int[] br = { 35, 27, 40, 26, 80 };
//
//		// ex02-1) 짝수의 개수
//		int count = 0;
//		for (int i = 0; i < br.length; ++i) {
//			if (br[i] % 2 == 0) {
//				++count;
//			}
//		}
//		System.out.println("짝수의 개수: " + count);
//
//		// ex02-2) 짝수의 개수와 홀수의 개수
//		int count2 = 0;
//		int count3 = 0;
//		for (int i = 0; i < br.length; ++i) {
//			if (br[i] % 2 == 0) {
//				++count2;
//			} else {
//				++count3;
//			}
//		}
//		System.out.println("짝수의 개수: " + count2);
//		System.out.println("홀수의 개수: " + count3);
//		
		// ex02-3) 짝수의 합계, 홀수의 합계
		int sumEven = 0; // 짝수: Even
		int sumOdd = 0; // 홀수: Odd
		for (int i = 0; i < br.length; i++) {
			if (br[i] % 2 == 0) {
				sumEven += br[i];
			} else {
				sumOdd += br[i];
			}
		}
		System.out.println("짝수의 합계: " + sumEven);
		System.out.println("홀수의 합계: " + sumOdd);

	} // main end

}
