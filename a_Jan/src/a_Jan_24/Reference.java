package a_Jan_24;

// 하나의 소스파일에 둘 이상의 클래스를 만드는 것은 금기!...지만 가능은 하다
class Student {
	String name =  "홍길동";
	 int age = 20;
}

public class Reference {
	public static void main(String[] ar) {
		// 클래스의 변수를 객체라고 한다
		// python >> s = Student()
		Student s = new Student();
		
		// 자바에서 기본타입 변수는 값을 직접 저장하고 있다.
		int a = 100; // a는 객체가 아니다!
		// 8가지 기본타입을 제외한 모든 변수(객체)는 4바이트 크기의 리모콘(참조변수)이다.
		// => 자바에서 객체는 모두 참조변수이다. (파이썬도 마찬가지)
		// 자바에서 객체는 값을 저장하는 것이 아니라 객체 번호를 가진다
		
		// a는 값을 직접 담고 있고 s는 값을 직접 담고있는게 아니라 저기 어디 담겨있는 느낌
		// s1 s2가 냉장고라고 생각하면 위치를 바꾸라 했을 때 그냥 그 리모컨 두개를 바꾼다
	}
}
