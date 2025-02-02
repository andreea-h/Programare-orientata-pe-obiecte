import java.util.*;

public abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
	public abstract AMatrix<T> addition(AMatrix<T> m1);
	//Aduna doua elemente de tip T si intoarce rezultatul
	public abstract T sum(T obj1, T obj2);
}

class IntegerMatrix extends AMatrix{
	public String toString() {
		String rez=new String();
		Iterator i1=this.iterator();  //iterator pe linii
		while(i1.hasNext()) {
			ArrayList<Integer>line = new ArrayList<Integer>();
			line=(ArrayList<Integer>)i1.next();
			Iterator i2=line.iterator();  //iterator prin linia matricii
			while(i2.hasNext()) {
			//	System.out.println(i2.next());
				rez=rez.concat(i2.next().toString()+" ");
			}
			rez=rez.concat("\n");
		}
		return rez;
	}
	
	public Integer sum(Number obj1, Number obj2) {
		return (Integer)obj1+(Integer)obj2;
	}
	
	public AMatrix addition(AMatrix m) {
		Iterator  k1 = this.iterator();
		Iterator  k2 = m.iterator();
		//result este matricea care contine rezultatul adunarii
		IntegerMatrix result = new IntegerMatrix();
	
	    while(k1.hasNext() && k2.hasNext()) {
	    	ArrayList<Integer> line1 = new ArrayList<Integer>();
	    	line1=(ArrayList<Integer>)k1.next();
	    	//System.out.println(line1);
	    	ArrayList<Integer> line2 = new ArrayList<Integer>();
	    	line2=(ArrayList<Integer>)k2.next();
	    	ArrayList<Integer> line3 = new ArrayList<Integer>();
	    	//iterator pentru a treia matrice
	    	//System.out.println(line2);
	    	Iterator <Integer> i = line1.iterator();
	    	Iterator <Integer> j = line2.iterator();
	    	//Iterator <Integer> k = line3.iterator();
	    	int index1=0;
	    	int index2=0;
	    	int index3=0;
	    	while (i.hasNext()&&j.hasNext()) {
	    		//System.out.println(i.next());
	    		//System.out.println(j.next());
	    		Integer x=i.next();
	    		Integer y=j.next();
	    		Integer suma = sum(x,y);
	    		line3.add(suma);
	    		index1++;
	    		index2++;
	    		index3++;
	    	}
	    	result.add(line3);  //adauga la matricea rezultat ultima linie calculata
	    }
	    return result;
	}
}
