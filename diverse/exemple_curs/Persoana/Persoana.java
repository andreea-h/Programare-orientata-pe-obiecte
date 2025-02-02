import java.util.*;

class MyComp implements Comparator {
	public int compare(Object o1, Object o2) {
		Persoana p1 = (Persoana)o1;
		Persoana p2 = (Persoana)o2;
		return p1.nume.compareTo(p2.nume);
	}
}

public class Persoana implements Comparable{
	private int cod ;
	 String nume ;
	public Persoana ( int cod , String nume ) {
	this .cod = cod;
	this . nume = nume ;
	}
	public String toString () {
	return cod + " \t " + nume ;
	}
	
	public int compareTo(Object o) {
		if(o == null) {
			throw new NullPointerException();
		}
		if(!(o instanceof Persoana)) {
			throw new ClassCastException("NU SE POT COMPARA");
		}
		Persoana p = (Persoana)o;
		return (this.cod - p.cod);
	}
}

class Sortare {
	public static void main ( String args []) {
		Persoana p[] = new Persoana [3];
		p[0] = new Persoana (3, " Ionescu ");
		p[1] = new Persoana (1, " Vasilescu ");
		p[2] = new Persoana (2, " Georgescu ");
		java.util.Arrays.sort (p);
		System . out. println (" Persoanele ordonate dupa cod:");
		for (int i=0; i<p. length ; i++) {
			System . out. println (p[i]);
		}
		
		Persoana p1[] = new Persoana [3];
		p1[0] = new Persoana (3, " Ionescu ");
		p1[1] = new Persoana (1, " Vasilescu ");
		p1[2] = new Persoana (2, " Georgescu ");
		
		Arrays.sort(p, new MyComp());
		for (int i=0; i<p. length ; i++) {
			System . out. println (p[i]);
		}
		
	}
}
