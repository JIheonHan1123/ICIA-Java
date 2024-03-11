package a_feb_29;

// 추상 메소드 많이 사용하나요? 물 마시듯이
// 왜 사용하느냐? 오버라이드와 함께
abstract class Parent {
	public abstract void insa();
}

// 추상클래스 Parent를 상속하면 자식도 추상클래스가 된다
class 첫째딸 extends Parent {

	@Override
	public void insa() {
		// TODO Auto-generated method stub

	}

}

//class 둘째아들 extends Parent {
//	public void hello() {
//		System.out.println("하이~");
//	}
//}

public class C_추상메소드Test2 {

}