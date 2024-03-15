package a_Jan_29;

// 자바에서 java.lang 패키지는 import없이 사용할 수 있다. ex) String, Math, Integer, System ...
import java.util.Scanner;

// 사용자로부터 값 입력받기: Scanner 클래스가 필요
// 자바의 모든 클래스는 패키지를 가진다.
// 자바가 실행될 때 모든 패키지를 다 읽어오지는 않는다.
// 필요한 것만 import해서 사용
public class Ex5_Scanner {
	public static void main(String[] args) {
		// 키보드에서 입력받는 스캐너 객체 생성
//		Scanner s = new Scanner(System.in);
//		System.out.print("숫자입력>> ");
//		int a = s.nextInt();
//		System.out.println(a);

//		
		// ex1) 키를 입력받아 적정체중을 출력
		// cf) 적정체중은 키-105로 가정
		Scanner s = new Scanner(System.in); // 스캐너 객체는 한번만 만들어도 된다.
		// 프로그램 3개 만들거니까 키보드 3개가 필요한건 아니기 때문
		System.out.print("키 입력>> ");
		int height = s.nextInt();
		System.out.println("적정체중은 " + (height - 105));

		// ex2) 면적을 정수로 입력받아 평을 출력
		// cf) 평 = 면적/3.3
		System.out.print("면적 입력>> ");
		int area = s.nextInt();
		System.out.println((int) (area / 3.3) + "평");

		// ex3) 반지름을 정수로 입력받아 원의 둘레 출력
		System.out.print("반지름 입력>> ");
		int r = s.nextInt();
		System.out.println("반지름은 " + (2 * Math.PI * r));
//		
	}
}