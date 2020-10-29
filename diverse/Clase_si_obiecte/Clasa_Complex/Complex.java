
public class Complex {
	
	private double a,b;
	
	Complex(double a,double b) {
		this.a=a;
		this.b=b;
	}
	
	public Complex aduna(Complex comp) {
		return new Complex(a+comp.a,b+comp.b);
	}
	
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Complex))
			return false;
		Complex comp=(Complex)obj;
		return(comp.a == a && comp.b == b);
		//	return true;		
	}
	
	public String toString() {
		if(b>0)
			return a+"+"+b+"*i";
		return a+""+b+"*i";
	}
	
	
	
	public static void main(String[] args) {
		Complex c1=new Complex(1,2);
		Complex c2=new Complex(2,3);
		System.out.println(c1.aduna(c2));
	}

}
