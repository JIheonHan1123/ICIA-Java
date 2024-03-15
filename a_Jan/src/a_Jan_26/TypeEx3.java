package a_Jan_26;

public class TypeEx3 {
//		자바의 연산
	// 1. 산술연산: +, -, *, /, %
	// double값이 들어오면 연살할 때 결과 타입에 주의 => 소숫점 잘려나갈 수도 있음 (돈에 관련된거라면 심각한 문제)
	public static void main(String[] args) {
		int 매출액 = 900;
		double 적립율 = 0.001; // 0.1%

		// 넓은 타입을 좁은 타입에 대입할 수 없다
		// 대입해야 한다면 형변환부터 하고 대입한다
		double r1 = 3 * 5;
		int r2 = (int) (1.0 + 2.3);
		System.out.println(r1); // 15를 double로 -> 15.0
		System.out.println(r2); // 3.3을 int로 -> 3

		System.out.println(매출액 * 적립율); // 0.9
		int 적립금 = (int) (매출액 * 적립율); // 0.9로 int로 바꾸면
		System.out.println(적립금 + "원"); // => 0이 나온다.
		// 이래서 double 값이 연산으로 들어오면 "결과타입"에 주의해야 함
	}
}
