import java.util.*;
public class Problema4 {

	public static void main(String[] args) {
		Vector vect1 = new Vector();
		Vector vect2 = new Vector();
		int i;
		for(i=1;i<=10;i++) {
			vect1.add(i*3+2);
			vect2.add(2*i);
		}
		System.out.println("Primul vector: " + vect1);
		System.out.println("Al doilea vector: " + vect2);
		//determinarea intersectiei celor 2 vectori
		Vector intersectie = new Vector();
		for(i=0;i<vect1.size();i++) {
			if(vect2.contains(vect1.get(i))) {
				intersectie.add(vect1.get(i));
				}	
		}
		System.out.println("Intersectia celor 2 vectori este: " + intersectie);;
		//reuniunea celor 2 vectori
		Vector reuniune = new Vector();
		for(i=0;i<vect1.size();i++)  {
			reuniune.add(vect1.get(i));
		}
		for(i=0;i<vect2.size();i++) {
			if(intersectie.contains(vect2.get(i))!=true) {
				reuniune.add(vect2.get(i));
			}	
		}
		System.out.println("Reuniunea celor 2 vectori este: " + reuniune);
		//diferenta dintre prima si a doua multime
		Vector diferenta = new Vector();
		for(i=0;i<vect1.size();i++) {
			if(vect2.contains(vect1.get(i))!=true)
				diferenta.add(vect1.get(i));
		}
		System.out.println("Diferenta dintre v1 si v2 este: " + diferenta);

	}

}
