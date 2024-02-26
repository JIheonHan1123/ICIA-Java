package a_feb_26;

public class Ex03_if {
	public static void main(String[] args) {
//		ex01
		int age = 24;
		if (age >= 65) {
			System.out.println("무료");
		} else if (age >= 25) {
			System.out.println("대인(3000원)");
		} else { // else는 조건을 적지 않기(don't care) 때문에 else의 조건이 눈에 보일 때만 사용
			System.out.println("무료");
		}

//		ex02
		int 고과점수 = 70, 매출액 = 8000, 수금액 = 7000;
		if (고과점수 >= 70) {
		} else if (매출액 >= 10000) {
		} else if (수금액 >= 10000) {
		} else {
			// ?????????????????
		}
	}
}
