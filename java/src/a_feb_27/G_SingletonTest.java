package a_feb_27;

// 싱글톤은 객체를 하나만 생성하는 것을 보장하는 패턴

// BoardService를 싱글톤으로 만드려면...
class BoardService {
	// 1번 문제 해결책 : private 생성자
	private BoardService() {
	}

	// 2번문제 해결책 : 클래스 내부에 자기자신의 객체를 만든다
	private static BoardService service = new BoardService();

	// 3번문제 해결책 : 객체 빌려주는 메소드 추가
	public static BoardService getInstance() {
		return service;
	}
}

public class G_SingletonTest {
	public static void main(String[] args) {
		// 1번 문제: 외부에서 객체를 마음대로 생성하게 없게
		// BoardService service = new BoardService();

		// 2번문제 : 그럼 이제 객체가 없잖아???

		// 3번문제 : 사용하게 객체 주세요~~~~
		BoardService s1 = BoardService.getInstance();
		BoardService s2 = BoardService.getInstance();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}