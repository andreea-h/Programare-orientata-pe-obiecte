
class C1 {
	private int x=1;
	void C1() {
		System.out.println(x+" ");
	}
}

class C2 extends C1 {
	private int x=3;
	void C1() {
			super.C1(); {
			System.out.println(x+" ");
		}
	}
}

class Test {
	public static void main(String args[]) {
		C2 object = new C2();
		object.C1();
	//	System.out.println(object.x);
	}
}