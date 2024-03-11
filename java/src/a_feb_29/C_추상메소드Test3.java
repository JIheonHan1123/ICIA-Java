package a_feb_29;

abstract class Vehicle3 {
	public abstract void drive();
}

class Truck3 extends Vehicle3 {
	public void drive() {
		System.out.println("트럭이 달려갑니다.");
	}
}

class Bus3 extends Vehicle3 {
	public void drive() {
		System.out.println("버스가 달려갑니다.");
	}
}

class Airplane3 extends Vehicle3 {
	public void drive() {
		System.out.println("비행기가 활주하면서 날아오릅니다");
	}
}

public class C_추상메소드Test3 {
	public static void main(String[] args) {
		Vehicle3 v = new Airplane3();
		Vehicle3 v2 = new Truck3();

		v.drive();
		v2.drive();
	}
}