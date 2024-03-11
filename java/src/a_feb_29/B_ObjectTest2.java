package a_feb_29;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
// toString메소드를 만들어라
@ToString
// equals 메소드와 hashCode 메소드를 만들어라
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class 상품 {
	private String name;
	private int price;
}

public class B_ObjectTest2 {
	public static void main(String[] args) {
		상품 p = new 상품("노트", 2000);
		System.out.println(p);
	}
}