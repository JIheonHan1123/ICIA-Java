package a_feb_28;

import lombok.ToString;

//this, super, this(), super()

//렌트카는 따로 지정하지 않으면 제조사 : 현대, 배기량 : 1300cc 차량이 기본이라고 하자

//객체를 생성하는 순서
//1. 인스턴스 초기화
//		장점 - 간단하다
//		단점 - 모든 객체가 같은 값을 가진다
//2. static 필드를 초기화하는 영역
//		static { }
//3. 생성자

//객체를 출력하면 hashCode를 찍는데...객체가 가진 필드값을 찍도록 바꾸는 lombok 어노테이션
@ToString
class 렌트카 {
	// 인스턴스 초기화 : 필드에 값을 직접 입력한다
	String 제조사 = "현대";
	Long 배기량 = 1300L;

	static {
		// 정적 초기화 영역
	}

	public 렌트카(String 제조사, Long 배기량) {
		this.제조사 = 제조사;
		this.배기량 = 배기량;
	}

	public 렌트카(String 제조사) {
		this.제조사 = 제조사;
	}

	public 렌트카(Long 배기량) {
		this.배기량 = 배기량;
	}

	public 렌트카() {

	}
}

public class C_Test1 {
	public static void main(String[] args) {
		렌트카 r1 = new 렌트카();
		렌트카 r2 = new 렌트카(2000L);
		렌트카 r3 = new 렌트카("기아", 2000L);

		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
