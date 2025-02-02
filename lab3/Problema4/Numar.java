
class Numar {
	private int intreg;
	
	public Numar(int intreg) {
		this.intreg = intreg;
	}
	
	//returneaza suma dintre nr (membrul clasei) si a
	public int suma(int a) {
		return intreg + a;
	}
	//returneaza suma dintre nr, a si b
	public int suma(int a, int b) {
		return this.suma(a+b);
	}
	//returneaza suma dintre nr, a, b si c
	public int suma(int a, int b, int c) {
		return this.suma(a+b,c);
	}
	//returneaza suma dintre nr, a, b, c si d
	public int suma(int a, int b, int c, int d) {
		return this.suma(a,b,c+d);
	}
	
	public String toString() {
		return intreg+"";
	}
	
	public static void main(String[] args) {
		Numar n1 = new Numar(1);
//		System.out.println(n1);
		System.out.println(n1.suma(5));
		System.out.println(n1.suma(1,2));
		System.out.println(n1.suma(1,2,3));
		System.out.println(n1.suma(1,2,3,4));
		
	}
}
