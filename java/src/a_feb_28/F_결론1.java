package a_feb_28;

//개방폐쇄원칙

//=== 동물
//=== Cat, Dog, Pig는 Animal로 대표된다
class F_Animal {
}

class F_Cat extends F_Animal {
}

class F_Dog extends F_Animal {
}

class F_Cow extends F_Animal {
}

//=== 수의사
//=== 동물의 외부 패키지에는 동물을 대표하는 Animal로 작업한다
class F_Hospital {
	public void 예방접종(Animal animal) {
	}
}

public class F_결론1 {
	public static void main(String[] args) {
		F_Hospital h = new F_Hospital();
		h.예방접종(new Cat());
		h.예방접종(new Dog());
		h.예방접종(new Cow());
	}

}