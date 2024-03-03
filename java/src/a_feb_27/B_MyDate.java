package a_feb_27;

import lombok.*;

@Getter
@Setter
public class B_MyDate {
	private Long year;
	private Long month;
	private Long day;

	public B_MyDate() {
	}

	public B_MyDate(Long year, Long month, Long day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
}