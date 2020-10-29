class Test {
	public static void main(String args[]) {
		B.C obj = new B().new C();
	}
}

class A {
	int val;
	A(int v) {
		val = v;
		System.out.println(val+"dinA");
	}
}

class B extends A {
	int val = 1;
	B() {
		super(2);
		System.out.println(val+"din B");
	}
	class C extends A {
	C(){
		super(4);
		System.out.println(B.this.val);
		System.out.println(C.this.val);
		System.out.println(super.val);
	}
	}
}