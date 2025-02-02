import java.util.*;
class Tren implements Comparable {
	Vector vagoane;
	public Tren() {
		vagoane = new Vector();
	}
	
	public void addVagon(Vagon cal) {
		vagoane.add(cal);
	}
	
	public int compareTo(Object o) {
		Tren t = (Tren)o;
		int i;
		int colete1=0; 
		for(i=0;i<vagoane.size();i++) {
			Vagon n = (Vagon)(vagoane.get(i));
			colete1=colete1+n.colete;
		}
		int colete2=0;
		for(i=0;i<t.vagoane.size();i++) {
			Vagon n = (Vagon)(t.vagoane.get(i));
			colete2=colete2+n.colete;
		}
		return colete1-colete2;
	}
	
	public String toString() {
		String rez = new String();
		int i;
		for(i=0;i<vagoane.size();i++) {
			rez = rez+vagoane.get(i).getClass().getName()+" "+((Vagon)vagoane.get(i)).colete+" colete";
			rez = rez+"-- "+((Vagon)vagoane.get(i)).pasageri+" pasageri";
			rez = rez + "\n";
		}
		return rez;
	}
}

class CalatoriA extends Vagon {
	
	CalatoriA() {
		pasageri = 40;
		colete = 300;
	}
	
	public void servicii() {
		System.out.println("două servicii pentru deschiderea, respectiv închiderea automată a ușilor.");
	}
}

class CalatoriB extends Vagon {
	
	CalatoriB() {
		pasageri = 50;
		colete = 400;
	}
	public void servicii() {
		System.out.println("două servicii pentru deschiderea, respectiv închiderea automată a ușilor;\n" + 
				"fiind un vagon mai nou, furnizează un serviciu automat pentru blocarea geamurilor.");
	}
}

class Marfa extends Vagon {
	
	Marfa() {
		colete = 400;
	}
	public void servicii() {
		System.out.println("nu furnizează servicii pentru deschiderea, respectiv închiderea automată a ușilor, aceste operații executându-se manual.");
	}
}


abstract class Vagon {
	int pasageri;
	int colete;
	
	abstract void servicii();
}