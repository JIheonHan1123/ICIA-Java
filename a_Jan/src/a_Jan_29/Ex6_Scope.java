package a_Jan_29;

// Scope: 변수의 사용 범위

// 파이썬의 경우 함수가 스코프를 생성한다
// 자바의 경우 중괄호{}가 스코프를 생성한다

public class Ex6_Scope {
	public static void main(String[] args) {

		int a = 10;
		{
			int b = 20;
			System.out.println(a); // 안에서 밖은 보인다.
			System.out.println(b);
		}
		System.out.println(a);
//		System.out.println(b); // 에러. 밖에서 안은 안보인다.

	}
}