package a_Jan_29;

/*
 *  연산자(operator): 항은 값을 말한다.
 *  1. 단항연산: . , ++, --, !, (타입)
 *  2. 이항연산
 *  	- 산술연산: +, -, *, /
 *  	- 비교연산: >, >=, <, <=,  ==, !=
 *  	- 논리연산: && (and), || (or)
 *  3. 삼항연산: ? :
 *  4. 대입연산: +=, -=, *= ...... =
 * 
 * */

// 연산할 때 타입 변환
public class Ex3_Operator {
	public static void main(String[] args) {
		// 1. 같은 타입을 연산하면 결과도 그 타입이다.
		int a = 100;
		long b = 100; // 안되는건데 2.에 따라 가능

		// 2. 다른 타입을 연산하면 표현할 수 있는 범위가 넓은 타입으로 (자동변환)
		long c = a + b;
		// int d = c; 불가능
		// long e = a; 가능
		int f = (int) c;

		// 3. 개발자가 강제로 타입을 바꾸려면 (타입명)을 사용 (수동변환)
		int g = (int) c;
		int h = (int) 3.14;

		///////////////////////////////////////////////////////////////////////////
//		1. 단항연산
		// 1) 멤버연산(.)
		String str1 = "Hello";
		System.out.println(str1.hashCode());

		// 2) 증감연산
		// 증감연산은 전위(prefix) 또는 후위(postfix)로 사용할 수 있다
		// ++: 1증가, --: 1감소
		int bb = 10;
		int cc = 10;

		// 전위
		++bb; // 11
		// 후위
		cc++; // 11
		// => 단독으로 사용할 때는 차이가 없다

		// 단독으로 사용하지 되지 않을 때,
		// 전위는 증감부터, 후위는 증감을 나중에한다
		System.out.println(++bb); // 증감부터 하고 출력 = 12
		System.out.println(cc++); // 출력부터 하고 출력 = 11
		System.out.println(bb == cc);

		// ex) 전위후위
		int num1 = 10, num2 = 10;
		int x = num1++;
		int y = ++num2;

		System.out.println(num1); // 11
		System.out.println(num2); // 11
		System.out.println(x); // 10
		System.out.println(y); // 11

		///////////////////////////////////////////////////////////////////////////
//		2. 이항연산
		// a) 산술연산
		// a1) 덧셈
		// 덧셈시 문자열이 있으면 나머지도 다 문자열로 바꿔서 합친다
		System.out.println(3 + 5);
		System.out.println(3 + "5");
		System.out.println("3" + 5);

		// ex) n1을 문자열로 바꿔서 대입하시오
		int n1 = 1234;
		String str2 = n1 + "";

		// a2) 뺄셈
		// a3) 곱셈

		// a4) 나눗셈
		// 파이썬에서는 나눗셈은 /, 몫은 //을 사용했지만
		// 자바에서 /는 몫이다. -> 결과가 모두 정수

		//
		// b) 비교연산
		// 파이썬과 동일. pass

		//
		// c) 논리연산
		// c1. && : and연산. 하나라도 거짓이면 거짓
		// c2. || : or연산. 하나라도 참이면 참
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = b1 && b2; // false
		boolean b4 = b1 || b2; // true

		// ex)
		int q = 10;
		int w = 20;
		// 논리연산은 참거짓이 확정되면 거기서 멈추기 때문에
		// w값이 증가하지 않는다
		// 산술연산과 논리연산을 섞어서 쓰면 안된다
		// why? 산술연산이 실행된다는 보장이 없기 때문.
		boolean z = q > 100 && ++w > 10;
		System.out.println(w); // 20

		///////////////////////////////////////////////////////////////////////////
//		3. 삼항연산
		// if~else에 해당

		int height = 175;
		// ex)
		// 키가 200이상이면 "키다리", 아니면 "보통"
		// 결과 = 조건식? 참일때 : 거짓일때;
		String result = height > 200 ? "키다리" : "보통";
		System.out.println(result);

		// ex) 3항을 쓰면 코드가 깔끔해지는 경우
		int xx = 100;
		int yy = 200;
		int large;
		int small;

		// 얘를
		if (xx > yy) {
			large = xx;
			small = yy;
		} else {
			large = yy;
			small = xx;
		}

		// 이렇게
		large = xx > yy ? xx : yy;
		small = xx > yy ? yy : xx;

	}
}
