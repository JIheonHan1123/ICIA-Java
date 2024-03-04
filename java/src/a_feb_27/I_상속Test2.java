package a_feb_27;

//자식의 공통점들을 모아서 부모 클래스를 만든다
//부모를 상속받아 코드를 재사용하자
class Product {
	Long price = 1000L;
}

class Pen extends Product {
	String name = "펜";

	void 상품소개() {
		System.out.println(price + "원짜리 " + name);
	}
}

class Note extends Product {
	String name = "노트";

	void 상품소개() {
		System.out.println(price + "원짜리 " + name);
	}
}

public class I_상속Test2 {

}
