import java.util.*;
public class Test03 {

	public static void main(String[] args) {
		IntegerMatrix m = new IntegerMatrix();
		ArrayList linia1=new ArrayList();
		linia1.add(5);
		linia1.add(3);
		linia1.add(4);
		linia1.add(5);
		m.add(linia1);
		ArrayList linia2=new ArrayList();
		linia2.add(3);
		linia2.add(8);
		linia2.add(9);
		linia2.add(10);
		m.add(linia2);
		ArrayList linia3=new ArrayList();
		linia3.add(13);
		linia3.add(85);
		linia3.add(99);
		linia3.add(100);
		m.add(linia3);
		System.out.println("Matricea 1:");
		System.out.println(m);
		IntegerMatrix m1 = new IntegerMatrix();
		ArrayList linia11=new ArrayList();
		linia11.add(25);
		linia11.add(43);
		linia11.add(84);
		linia11.add(95);
		m1.add(linia11);
		ArrayList linia22=new ArrayList();
		linia22.add(39);
		linia22.add(83);
		linia22.add(92);
		linia22.add(102);
		m1.add(linia22);
		ArrayList linia33=new ArrayList();
		linia33.add(132);
		linia33.add(852);
		linia33.add(991);
		linia33.add(100);
		m1.add(linia33);
		System.out.println("Matricea 2:");
		System.out.println(m1);
		System.out.println("Matricea suma:");
		System.out.println(m1.addition(m));
	}

}
