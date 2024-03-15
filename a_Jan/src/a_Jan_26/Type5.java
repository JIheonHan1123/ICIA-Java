package a_Jan_26;

public class Type5 {
	public static void main(String[] args) {
		// 1. 자바는 변수를 만들 때 타입을 지정한다
		int a = 10;

		// 2. 자바에서 클래스가 아니면 소문자로 시작한다
		// 여러 단어일 경우 첫 글자를 대문자로
		int sumOfAllStudent = 300;

		// 3. 변수는 한줄에 하나씩
		int b = 10;
		int c = 17;

		// 4. 변수는 반드시 초기화 해야한다.
		int x; // 4바이트짜리의 정수를 저장할 공간만 만든 것
		x = 10; // 초기화(초기 값 설정)
		System.out.println(x);

		// 5. 기본타입(정수, 실수, boolean, (문자))은 값을 직접 저장한다. -> 문자는 거의 안씀
		// cf) 기본타입을 제외하면 모두 객체를 가리키는 참조타입이다.

		// 6. 현대 프로그래밍 언어는 모두 참조타입을 사용한 간접 조작 방식을 사용한다 ex) 파이썬
	}
}
