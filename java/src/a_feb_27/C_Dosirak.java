package a_feb_27;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class C_Dosirak {
	private String name;
	private Long price;
	private B_MyDate productDay;

	public C_Dosirak() {
	}

	public C_Dosirak(String name, Long price, B_MyDate productDay) {
		this.name = name;
		this.price = price;
		this.productDay = productDay;
	}
}
