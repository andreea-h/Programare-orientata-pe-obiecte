
class C1 {
	int x=1;
	C1(int x) {
		this.x=x;
	}
}


class C2 extends C1 {
	static int y=3;
	C2(int x) {
		this(x,y);
	}
	
	C2(int x, int y) {
		super(x);
		this.y=y;
	}
	
	public String toString() {
		return "x=" +x+",y="+y;
	}
}

class Test {
	public static void main(String args[]) {
		C2 ob1 = new C2(4);
	
		System.out.println(ob1+" ");
		C2 ob2 = new C2(5,6);
		
		System.out.println(ob2);
	}
}
