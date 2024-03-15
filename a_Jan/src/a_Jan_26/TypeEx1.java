package a_Jan_26;

public class TypeEx1 {
	public static void main(String[] args) {
		/*
		 * 변수를 만들고 주민번호를 저장
		 */
		String jumin1 = "010101-0101010";

		// -를 제외하고 숫자로 주민번호를 저장
		// literal: 코드에 직접 적은 값. ex) a = 10
		// 리터럴의 타입은 int, double, String
		// 리터럴도 타입이 있다. 그래서 리터럴 뒤에 알파벳 붙여줘야 함 long타입이면  L을 붙여준다
		long jumin2 = 9910101020011L;
		System.out.println(jumin1);
		System.out.println(jumin2);
		
		// x는 10억 + 20억 => int의 범위를 넘친다. 넘치면 -가 됨 => 21억 + 1하면 -21억이 됨0
		int x = 1000000000 + 2000000000;
		System.out.println(x);
	}
}
