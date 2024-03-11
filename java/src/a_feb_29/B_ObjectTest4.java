package a_feb_29;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
class Apple {
	private String name;
	private int price;

	// 어떤 경우에 두 객체가 같은 거니?...프로그래머가 아니라 업무 규칙
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Apple) == false) {
			return false;
		}
		Apple target = (Apple) obj;
		return this.price == target.getPrice();
	}
}

public class B_ObjectTest4 {
	public static void main(String[] args) {
		Apple a1 = new Apple("대구 사과", 3500);
		Apple a2 = new Apple("경북 능금", 3500);

		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));
	}
}