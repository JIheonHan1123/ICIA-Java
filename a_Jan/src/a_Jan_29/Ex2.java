package a_Jan_29;


// gb: guest book
// create table gb(gno number. content varchar2, write_day date)
class GuestBook {
	int gno;
	String content;
	String writeday; //Date있는데 import하기 귀찮으니까 일단 String으로
}

public class Ex2 {
	public static void main(String[] args) {
		// 참조변수 obj는 객체번호(정수)를 가진다. 값이 들어있는게 아님                     
		GuestBook obj = new GuestBook();
		System.out.println(obj.hashCode());
	}
}