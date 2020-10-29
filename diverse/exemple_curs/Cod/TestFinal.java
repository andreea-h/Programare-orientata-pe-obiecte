
abstract class C1 {
	private int x=2;
	public abstract String f() ;
	int getX() {
		return x;
	}
}

final class C2 extends C1 {
	int y=3;
	public String f() {
		return "x= "+super.getX()+",y="+y;
	}

}

class TestFinal {
	public static void main(String args[]) {
		C2 object = new C2();
		System.out.println(object.f());
	}
}