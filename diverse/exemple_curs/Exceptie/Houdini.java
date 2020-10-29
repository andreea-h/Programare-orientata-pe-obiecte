import java.util.*;
class MyException extends Exception {
	
}

class Parent {
	void say(List<? extends Number> list) {
		System.out.println("parent");
	}
}
class Child extends Parent {
	void say(List<? extends Number> list) {
		System.out.println("child");
	}
}


class Parent1 {
	void say(List<? extends Number> list) {
		System.out.println("parent");
	}
}
class Child1 extends Parent1 {
	void say(List<Integer> list) {
		System.out.println("child");
	}
}


class Test {
    void say(Set<Double> set) {
    }
    void say(Set<Boolean> set) {
    }
}

public class Houdini {
	public static void main(String args[]) throws Exception {
		try {
			throw new MyException();
		}
		catch(MyException e) {
			System.out.println("S-a aruncat o exceptie");
		}
		finally {
		System.out.println("success");
		}
		
		//throw new MyException() ;
		int v[]=new int[10];
		
		try {
			v[10] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Atentie la indecsi!");
			e.printStackTrace();
		} // Corect, programul continuă
	//	v[11] = 0; //eroare la executie, nu la compilare
		finally {
		int a=1;
		int b=0;
		try {
			System.out.println(a/b);
		}
		catch(ArithmeticException e) {
			System.out.println("Impartire ilegala int/0");
		}
		double x=1, y=-1, z=0;
		System.out.println(x/z); // Infinity
		System.out.println(y/z); // -Infinity
		System.out.println(z/z); // NaN
		System.out.println(a/z); //Infinity
		System.out.println(z/b); //NaN
		List<Number> w = null;
		List<Integer> ww = null;
		List<? extends Number> list1 = null;
		List<Integer> list2 = null;
		list1 = list2;
		
		}
	}
}
