
class Fractie {
	
	double numarator;
	double numitor;
	
	public Fractie() {
		this(0,1);
	}
	
	public Fractie(double numarator, double numitor) {
		this.numarator=numarator;
		this.numitor=numitor;
	}
	
	Fractie suma(Fractie f) {
		Fractie a=new Fractie(numarator*f.numitor+numitor*f.numarator,numitor*f.numitor);
		return a;
		}
	
	public String toString() {
		return numarator+"/"+numitor;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Fractie)) 
			return false;
		Fractie f=(Fractie) obj;
		return(this.numarator * f.numitor == this.numitor *f.numarator);
	}

	
	public static void main(String[] args) {
		Fractie f1 = new Fractie(1,2);
		Fractie f2 = new Fractie(2,4);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f1.suma(f2));
		System.out.println(f1.equals(f2));
	}

}
