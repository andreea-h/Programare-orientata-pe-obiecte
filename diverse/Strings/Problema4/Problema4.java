import java.util.*;
public class Problema4 {

	public static void main(String[] args) {
		Vector vect1 = new Vector();
		Vector vect2 = new Vector();
		Vector reuniune = new Vector();
		Vector intersectia = new Vector();
		Vector diferenta = new Vector();
		vect1.add(1);
		vect1.add(2);
		vect1.add(3);
		vect1.add(4);
		vect2.add(1);
		vect2.add(2);
		vect2.add(30);
		vect2.add(5);
		int i;
		for(i=0; i<vect1.size(); i++)
			if(vect2.contains(vect1.get(i)))
				intersectia.add(vect2.get(i));
		System.out.println("Intersectia " + intersectia);

	}

}
