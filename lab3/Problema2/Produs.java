class Produs {
	String nume;
	double pret;
	int cantitate;
	public Produs(String nume, double pret, int cantitate) {
		
		this.nume=nume;
		this.pret=pret;
		this.cantitate=cantitate;
	}
	
	public String toString() {
		return "Produs: " + nume +", "+ pret + " "+cantitate;
	}
	
	public double getTotalProdus() {
		return pret*cantitate;
	}
}

class Magazin {
	Produs p1;
	Produs p2;
	Produs p3;
	String nume;
	public Magazin(String nume,Produs p1, Produs p2, Produs p3) {
		this.nume = nume;
		this.p1=new Produs(p1.nume, p1.pret,p1.cantitate);
		this.p2=new Produs(p2.nume, p2.pret,p2.cantitate);
		this.p3=new Produs(p3.nume, p3.pret,p3.cantitate);
	}
	
	public String toString() {
		return p1.toString()+"\n"+p2.toString()+"\n"+p3.toString();
	}
	
	public double getTotalMagazin () {
		return p1.getTotalProdus()+p2.getTotalProdus()+p3.getTotalProdus();
	}
	
	public static void main(String[] args) {
		Magazin mag = new Magazin("Jerry",new Produs("ciocolata",2,4),new Produs("mere",3,1),new Produs("alune",1,2));	
		System.out.println(mag);
		System.out.println(mag.getTotalMagazin());
	}
}

