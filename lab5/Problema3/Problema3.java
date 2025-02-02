import java.util.*;
public class Problema3 {
	Vector pozitivi;
	
	public Problema3() {
		pozitivi = new Vector();
	}
	
	public void myRead() throws Exception {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int n = s.nextInt();
			if(n<0) {
				String mesaj = new String("Numarul ointrodus este negativ");
				throw new Exception(mesaj);
			}
			if(n>=0) {
				pozitivi.add(n);
			}
		}
		s.close();
	}
	
	public String toString() {
		return pozitivi.toString();
	}
	
	public int maxim() {
		return (int)Collections.max(pozitivi);
	}
	
	public static void main(String args[]) {
		Problema3 o = new Problema3();
		try {
			o.myRead();
		}
		catch (Exception NumarNegativ) {
			System.out.println("Numarul introdus este negativ");
		}
	    finally {
	    	if(o.pozitivi.size()!=0) {
	    		System.out.println(o.pozitivi);
	    		System.out.println("Valoarea maxima este: "+o.maxim());
	    	}
	    	
	    }
		
	}
	
}
