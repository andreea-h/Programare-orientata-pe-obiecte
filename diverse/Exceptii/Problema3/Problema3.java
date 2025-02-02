import java.util.*;

public class Problema3 {
	Vector pozitive;
	public Problema3() {
		pozitive = new Vector();
	}
	//citire si adaugare in vector
	public void myRead() throws Exception {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int nr=s.nextInt();
			if(nr<0) {
				String mesaj = new String("Numarul introdus este negativ!");
				throw new Exception(mesaj);
			}
			if(nr>=0) {
				pozitive.add(nr);
			}
		}
		s.close();
	}
	
	int maxim() {
		return (int)Collections.max(pozitive);
	}
	
	public static void main(String args[]) {
		Problema3 o = new Problema3();
	   try {
			o.myRead();
		}
		catch(Exception NumarNegativ) {
			System.out.println("Numarul introdus este negativ!");
		}
		finally{
			if(o.pozitive.size()!=0) {
				System.out.println(o.pozitive.toString());
				System.out.println(o.maxim());
			}
		}
		    
	}
		
		
}
