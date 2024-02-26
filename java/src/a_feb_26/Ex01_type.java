package a_feb_26;

public class Ex01_type {
	public static void main(String[] args) {

		// 타입
//	 1. 기본타입: 정수, 실수, 문자, 참거짓

		// 정수는 크기가 커지면 표현 범위가 넓어짐
		int a = 10; // 4바이트 (약 -21억~21억)
		long b = 20; // 8바이트 (약 -922경~922경)

		// 실수는 크기가 커지면 정밀해진다 (실수는 근사값)
		float f = 10;
		float d = 10;

		// 문자형은 글자 1글자를 저장 -> 거의 사용 X
		char ch = 'A';

		// 참거짓
		boolean isChild = false;

//  2. 참조타입: 객체를 가리키는 4바이트 리모컨
		// 객체 자체는 이름이 없다 -> 참조변수로 작업한다
		String str = "Hello"; // String은 유일하게 new를 사용하지 않고 객체를 생성한다
		System.out.println(str.hashCode());
	}
}
