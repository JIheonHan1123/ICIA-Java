package a_feb_27;

class Calc {
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sub(int a, int b) {
		return a - b;
	}
}

public class D_StaticTest {
	public static void main(String[] args) {
		Calc c1 = new Calc();
		Calc c2 = new Calc();
		// 객체를 만든다 -> 두 객체는 달라야 한다
		// c1, c2의 객체는 동작은 항상 같다 -> static

		System.out.println(Calc.sum(3, 4));
	}
}