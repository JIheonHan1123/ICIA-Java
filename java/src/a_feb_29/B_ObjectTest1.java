package a_feb_29;

import lombok.AllArgsConstructor;

// Object 클래스 : 자바의 모든 클래스의 부모
// 부모클래스가 없는 경우 자동으로 extends Object가 추가된다

// Object 클래스의 역할 -> 자식이 override할 메소드의 이름을 정해준다

@AllArgsConstructor
class Product {
	private String name;
	private int price;

	// 이 메소드는 override되었다
	@Override
	public String toString() {
		return "name:" + name + ", price:" + price;
	}

	@Override
	public int hashCode() {
		// 객체를 구별하는 번호
		// 해시코드를 생성하는 자바 알고리즘이 충분히 강력하지 않네
		// 겹칠수도 있다네....불만이면 너가 만들어
		return super.hashCode();
	}
}

public class B_ObjectTest1 {
	public static void main(String[] args) {
		Product p = new Product("컵누들", 1500);

		// 자바의 모든 객체는 자신을 출력하는 toString() 메소드를 가진다
		// 객체를 print해 -> toString() 메소드가 자동 호출
		System.out.println(p.toString());
	}
}