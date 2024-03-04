package a_feb_27;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Sample {
	private Long jumsu;

	// 객체가 가진 jumsu로 합격, 불합격을 판정
	public String 판정1() {
		return jumsu >= 70 ? "합격" : "불합격";
	}

	// 외부에서 주어진 score로 합격, 불합격을 판정
	public static String 판정2(Long score) {
		return score >= 70 ? "합격" : "불합격";
	}
}

public class D_StaticTest2 {
	public static void main(String[] args) {
		// 객체를 new 한다 -> 객체의 정보가 다르다
		Sample s1 = new Sample(75L);
		Sample s2 = new Sample(65L);

		// 판정1() 메소드를 객체가 가진 필드로 계산 -> 객체마다 결과가 다르다
		// 필드에 접근한다 -> this가 필요하다 -> new가 필요
		System.out.println(s1.판정1());
		System.out.println(s2.판정1());

		// 판정() 메소드를 외부입력값으로 계산 -> 입력이 같으면 결과가 같다
		// 필드X -> thisX -> new X -> 클래스이름으로 사용
		System.out.println(Sample.판정2(75L));
		System.out.println(Sample.판정2(75L));
	}
}