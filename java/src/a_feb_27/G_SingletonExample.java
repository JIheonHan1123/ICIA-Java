package a_feb_27;

// 디자인 패턴
// Builder : 객체 생성의 난해함에 대처
// Singleton : 객체를 하나만 생성
//			   모든 멤버가 static인 클래스와 목적은 동일

public class G_SingletonExample {
	// 1. new 금지 -> private 생성자
	private G_SingletonExample() {
	}

	// 2. 자기자신의 static 필드를 가진다
	private static G_SingletonExample ob = new G_SingletonExample();

	// 3. 필드를 빌려주는 메소드를 추가한다
	public static G_SingletonExample getInstance() {
		return ob;
	}
}