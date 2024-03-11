package a_feb_29;

abstract class Sample {
	// 중괄호대신 ;을 찍으면 추상 메소드 -> 미구현 메소드
	// 추상메소드가 포함된 클래스 -> 추상 클래스
	public abstract void insa();
}

public class C_추상메소드Test1 {
	public static void main(String[] args) {
		// 미완성인 추상 클래스는 객체를 생성할 수 없다
//		Sample s = new Sample();
	}
}