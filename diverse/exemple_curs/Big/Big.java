import java.util.*;
public class Big {
	void met(int x) {
		
	}
}

class Heavy extends Big {
	//public void met(int x) {
		
	//}
	
	//protected void met(int x) { //suprasciere -> dynamic binding
		
	//}
}


class Weighty extends Heavy {
/*	String met(int x) {  //compile time error, nu este suficient sa se schimbe tipul returnat
		return "hi";
	}*/
	
/*	public int met(int x) {
		return 7;
	}*/
	
	private int met(char c) throws Exception {
		return 1;
	}
	
	ArrayList<Integer> go() {
		List<Integer> l = new ArrayList<Integer>();
		return (ArrayList<Integer>)l;
	}
}


class D 
{
	int method() {
		System.out.println("dubus");
		return 1;
	}
}

class E extends D {
	int method() {
		/////
		return 2;
	}
}

class F extends E {
	int fun(D d) {
		System.out.println("aici");
		return d.method();//se va apela metoda mostenita, adica method() din clasa E
	}
}

class Test {
	public static void main(String args[]) {
		F x = new F();
		System.out.println(x.fun(x));//upcast automat la tipul D
		try {
			throw new Error();
		}
		catch(Error e) {
			try {
				throw new RuntimeException();
			}
			catch(Throwable t) {
				
			}
		}
		System.out.println("ca");
	
		class Foo {
			public int i=3;
		}
		
		Object o = (Object)new Foo();
		Foo foo = (Foo)o;
		System.out.println(foo.i);
	}
}

class Outer {
	public void OuterMethod() {
		new Inner();
	}
	
	private class Inner {}
	
	static class Inner2 {
		public void cega() {
			System.out.println("aici");
		}
	}
	
	public static void main(String args[]) {
			Outer o = new Outer();
			Outer.Inner obj = o.new Inner();
			Outer.Inner2 obj2 = new Outer.Inner2();
			obj2.cega();
}
}


class X {
	static String s = "hello";
	public static void main(String args[]) {
		
		Vector<Complex> vect = new Vector<Complex>();
		new X().met(s);
		
		System.out.println(s);
		
		HashSet seat = new HashSet();
		seat.add(10.0);
		seat.add(2.0);
		System.out.println(seat);
		
	}
	
	void met(String s) {
		this.s="world";
		//System.out.println(this.s);
		String x= null;
	//	System.out.println(x.toString());
	}
}


class Complex {
	
}





