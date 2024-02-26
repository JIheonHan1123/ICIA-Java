package a_feb_26;

public class Ex02_wrapperClass {
	public static void main(String[] args) {
		// a는 10이라는 값만 저장
		int a = 10;

		// b는 값 외에 여러 메소드를 가진 객체
		Integer b = new Integer(10);

		System.out.println(a);
		System.out.println(b.MAX_VALUE);

//		Wrapper Class 개념 : 기본 타입의 값을 저장할 수 있으면서 객체의 특성까지 가진 클래스
		// 웹에서 사용자가 값을 입력하지 않으면 서버는 null을 가지게 된다
		// ex) 나이를 입력받는다면
		// int x = null; // int는 null을 못 가짐 -> 사용자가 입력하지 않으면 에러
		Integer y = null; // 그래서 Integer나 Long을 써야한다 -> Wrapper Class
	}
}
