package a_feb_27;

import java.util.ArrayList;

//처리하는 클래스 -> 객체 생성 X

public class E_GuestBookService {
	private static ArrayList<E_GuestBook> list = new ArrayList<>();

	public static void save(E_GuestBook gb) {
		list.add(gb);
	}

	public static ArrayList<E_GuestBook> findAll() {
		return list;
	}

	// 객체를 비교할 때는 ==아니라 equals메소드를 사용한다
	// 객체를 리턴하는 경우 실패하면 null을 리턴한다
	public static E_GuestBook findById(Long gno) {
		for (E_GuestBook gb : list) {
			if (gb.getGno().equals(gno)) {
				return gb;
			}
		}
		return null;
	}

	public static Boolean delete(Long gno) {
		return false;
	}
}
