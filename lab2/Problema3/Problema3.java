import java.util.*;

public class Problema3 {

	int eliminare(Vector vect, int x) {
		int k=0;
		int i;
		for(i=0;i<vect.size();i++) {
			if((int)vect.get(i)==x) {
				k++;
				vect.remove(i);
			}
		}
		return k;
			
	}
	
	public static void main(String[] args) {
		Vector vect = new Vector();
		//generare vector
		int i,nr;
		for(i=1;i<=20;i++) {
			Random generator = new Random();
			nr = generator.nextInt(10);
			vect.add(nr);
		}
		System.out.println("Vectorul generat random este " + vect);
		Problema3 obiect = new Problema3();
		System.out.println("Numarul de aparitii al lui " + 2 + " in vector este  " + obiect.eliminare(vect, 2));
		System.out.println("Dupa stergerea aparitiilor lui " + 2 + " vectorul este " + vect);
		//determinarea valorii maxime din vector
		int maxim = 0;
		for(i=0;i<vect.size();i++) {
			if((int)vect.get(i) > maxim)
				maxim = (int)vect.get(i);
		}
		System.out.println("Valoarea maxima din vector este " + maxim);
		//pozitia componentei minime a vectorului
		int minim = 9;
		for(i=0;i<vect.size();i++) {
			if((int)vect.get(i) < minim)
				minim = (int)vect.get(i);
		}
		int pos = vect.indexOf(minim) +1;
		System.out.println("Pozitia componentei minime este "+pos);
		//media aritmetica a componentelor 
		int suma = 0;
		for(i=0;i<vect.size();i++) {
			suma = suma + (int)vect.get(i);
		}
		float media = suma/vect.size();
		System.out.println("Media componentelor este " + media);
		
	}
}
