package a_Jan_26;

public class Type3 {
	public static void main(String[] args) {
		// 변수의 타입
//		기본타입: 변수가 값을 직접 저장 => 자바는 여기 8개 빼고 전부 다 참조변수 = 기본타입이 아니면 모두 객체
		// cf) 자바는 타입에 크기가 있다 ex) 1 = 1byte
		// 정수 - byte(1), short(2), int(4), long(8) 		- 정확한 값을 저장, 크기가 클수록 표현범위가 크다 (int는 대충 +- 21억, long은 +-926경)
		// 실수 - float(4), double(8)							- 근사값을 저장, 크기가 클 수록 정밀해진다. 
		// 참거짓 - boolean(1)
		// 문자 - char(2)

//		참조타입: 변수가 객체를 가리킨다(간접 조작) => 파이썬은 모든 것이 참조변수
		// 객체 - 클래스의 변수
		// 그 객체들이 객체번호를 가진다 (hash code)
		// 자바에서 객체는 new 키워드로 생성한다  
		int a = 100;
		Integer b = new Integer(100);
		
		// 기본타입 변수는 값을 가진다
		System.out.println(a);
		// 참조타입 변수는 객체 번호를 가진다
		System.out.println(b.hashCode());
	}
}
