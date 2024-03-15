package a_Jan_26;

public class Type4 {
	public static void main(String[] args) {
		int a = 10;
		double b = 3.14;
		boolean c = 5 > 3;
		
		// 자바의 기본타입 문자: 글자 1자
		// 자바에서 문자(char) 자료형은 거의 사용하지 않는다.
		// char 타입은 글자 1개를 의미
		char ch = 'a';
		
		// 자바에서 문자열 자료형은 String
		// String은 클래스이지만 기본타입인 것처럼 사용한다.
		// String은 유일하게 new를 사용하지 않고 객체를 생성한다. (유일한 예외)
		// '로 감싸면 1글자, "로 감싸면 여러글자
		String name = "홍길동";
		System.out.println(name.hashCode());
	}
}
