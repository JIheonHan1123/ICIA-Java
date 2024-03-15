package com.icia.b.feb01;

class Marine {
	// final: 변경불가능
	// static: 변경가능 (공유되는 값)
	// final static 또는 static final -> 변경 불가능한 공유되는 값 = 상수
	final static int 전체체력 = 40;
	int 현재체력 = 40;
	static int 공격력 = 6;
	static int 방어력 = 1;

	public static void 방업() {
		// 정적 메소드는 정적 멤버에만 접근할 수 있다.
		// 객체가 만들어졌는지 안만들어졌는지 모른다.
		// static은 static끼리만 접근가능
		// System.out.println(현재체력);
		방어력++;
	}

	public void 공업() {
		// 일반 메소드는 일반멤버, 정적멤버 모두 접근할 수 있다.
		System.out.println(현재체력);
		if (공격력 < 9) {
			공격력++;
		}
	}

}

public class Ex8_Obj_Marine {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		Marine m3 = new Marine();
	}
}
