package pkgB;

import pkgA.*; //import toate clasele din A

public class Baz {
	public static void main(String args[]) {
		Foo f = new Foo();
	//	System.out.println(" "+f.a); -> a nu este vizibila
	//	System.out.println(f.b);
		System.out.println(f.c); //c este public, deci este vizibil
		for(int __x=0;__x<3;__x++) ;
		int #b=7;
		
	}
}
