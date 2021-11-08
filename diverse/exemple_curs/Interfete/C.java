interface I1 {
	int a=1;
	void metoda();
}

interface I2 {
	int a=2;
	void metoda();
}

class C implements I1, I2{

	public void metoda() {
		System.out.println(I2.a);
	}
	
	public static void main(String args[]) {
		C obj = new C();
		obj.metoda();
	}
}
