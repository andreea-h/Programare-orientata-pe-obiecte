import java.util.*;
public class Problema3 {
	
	int aparitii(Vector vect, int x) {
		int i;
		int k=0;
		//System.out.println(vect.size());
		for( i=0; i < vect.size() ; i++)
			if(vect.get(i).equals(x)) {
				//System.out.println("se elimina de pe pozitia" + i);
				k++;
				//System.out.println("se sterge" + vect.remove(i));
				vect.remove(i);
				//i--;
			}
		return k;
	}

	public static void main(String[] args) {
		Vector vect = new Vector();
		//determinarea maximului din vector
		int i;
		for( i=0; i<20; i++) {
			Random generator = new Random();
			int nr = generator.nextInt(10);
			vect.add(nr);
			System.out.println(vect.get(i));
		}
		int max=0;
		int j;
		for( j=0; j<20; j++ ) {
			if( (int)vect.get(j) > max )
				max = (int) vect.get(j);
		}
		System.out.println("Maximul din vector este "+max);
		Problema3 object = new Problema3();
		System.out.println(object.aparitii(vect, 9));
	//	System.out.println(object.aparitii(vect, 9));
	}

}
