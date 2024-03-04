package a_feb_27;

// 상속 : 부모 것은 내 것
class 부모 {
	int 부모재산 = 1000000;
}

class 자식 extends 부모 {
	int 자식재산 = 50000;
}

public class I_상속Test1 {
	public static void main(String[] args) {
		자식 ob = new 자식();
		System.out.println(ob.부모재산);
		System.out.println(ob.자식재산);
	}
}