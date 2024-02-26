package a_feb_26;

import java.util.ArrayList;

import javax.swing.JButton;

// for문: 일반 for, 향상된 for
public class Ex04_for {
	public static void main(String[] args) {
		// 반복문을 사용하려면 데이터의 집합이 필요
		// 파이썬의 경우 list, set, tuple, dictionary
		// 이런 집합을 자바에서는 Collection 이라고 한다.

//		자바의 ArrayList객체 = 파이썬의 list = 자바스크립트의 배열		
		// 아래처럼 ArrayList를 만들면 아무거나 다 담을 수 있다 = 뭐가 튀어나올 지 모름
		ArrayList list1 = new ArrayList();
		list1.add(10);
		list1.add("Hello");
		list1.add(new JButton("클릭하세요"));

		// 그래서 담을 수 있는 값에 제한을 걸자 = Diamond 연산자
		ArrayList<Integer> list2 = new ArrayList<Integer>(); // 생략해서 ArrayList<Integer> list2 = new ArrayList<>(); 이렇게 만들 수 있음
		list2.add(10);
		list2.add(20);
		list2.add(20);
		// list2.add("Hello"); // Hello를 담을 수 없다

//		일반 for 
		// 이렇게 짜면 잘못 짠 코드
		for (int i = 0; i < 3; i++) {
			System.out.println(list2.get(i));
		}

		// list2는 객체임(Object) -> 객체는 자기 일은 자기가 알아서 하는 S/W부품
		// list2의 크기는 자기가 알고 있다
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}

//		향상된 for : 파이썬의 in, js의 of와 같음)
		ArrayList<Integer> list3 = new ArrayList();
		list3.add(10);
		list3.add(20);
		list3.add(30);
		for (Integer ob : list3) {
			System.out.println(ob);
		}

		ArrayList list4 = new ArrayList();
		list4.add(10);
		list4.add(20);
		list4.add(30);
		// for (??? ob : list4) { // 타입을 몰라서 적을 수가 없다
		// System.out.println(ob);
		// }

		// 자바의 모든 객체를 가리킬 수 있는 참조변수 타입은 object
		// object로 땜빵은 가능 -> 해결책은 아님
		for (Object ob : list4) {
			System.out.println(ob);
		}
	}
}
