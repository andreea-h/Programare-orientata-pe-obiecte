import java.util.*;

public class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;
 
    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }
    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }
 
    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }
    
    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }
 
    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }
 
    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }
 
    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }
 
    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
    }
 
    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array {
	
	 public void addElement(Integer x) {
		 super.addElement(x);
		 super.sort();
	 }
	 
	 public void addElement(Integer x, int poz) {
		 super.addElement(x, poz);
		 super.sort();
	 }
	 
	  public boolean remove(Integer x) {
		  boolean rez = super.remove(x);
		  super.sort();
		  return rez;
	  }
	  public Integer remove(int pos) {
	       Integer rez  = super.remove(pos);
	       super.sort();
	       return rez;
	    }
}

class MyStack {
	
	public Array stiva;
	
	public MyStack() {
		stiva = new Array();
	}
	
	//adauga un numar intreg in varful stivei
	void push(int x) {
		stiva.addElement(x);
	}
	
	int pop() {
		int nr = stiva.getSize();
		//System.out.println(nr);
		int element = stiva.get(nr-1);
		//System.out.println(element);
		stiva.remove(nr-1);
		return element;
	}
	
	public String toString() {
		return stiva.toString();
	}
}
