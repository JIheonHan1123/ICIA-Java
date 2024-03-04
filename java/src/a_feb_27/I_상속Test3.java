package a_feb_27;

//상속의 활용
class Parent {
	int a;
}

class Child extends Parent {
	int b;
}

public class I_상속Test3 {
	public static void main(String[] args) {
		// 1. 부모의 참조변수는 자식을 가리킬 수 있다
		// ob1은 Child 자체를 아닌 Child 내부의 Parent를 가리킨다
		Parent ob1 = new Child();
		System.out.println(ob1.a);
		// System.out.println(ob1.b);

		Child ob2 = new Child();
		System.out.println(ob2.a);
		System.out.println(ob2.b);
	}
}
