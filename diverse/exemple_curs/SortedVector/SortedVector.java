import java.util.*;

class MyComp1 implements Comparator {
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Pair)||(!(o2 instanceof Pair))) {
			throw new ClassCastException("Nu se pot compara");
		}
		Pair p1 = (Pair)o1;
		Pair p2 = (Pair)o2;
		return ((Comparable)p1.obj1).compareTo(p2.obj1);
	}
}

class MyComp2 implements Comparator {
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Pair)||(!(o2 instanceof Pair))) {
			throw new ClassCastException("Nu se pot compara");
		}
		Pair p1 = (Pair)o1;
		Pair p2 = (Pair)o2;
		return ((Comparable)p1.obj2).compareTo(p2.obj2);
	}
}

class SortedVector extends Vector{
	Comparator myComp;
	public SortedVector(Comparator myComp) {
		this.myComp = myComp;
	}
	public boolean add(Object o) {
		super.add(o);
		Collections.sort(this, myComp);
		return true;
	}
}

class Pair {
	Object obj1;
	Object obj2;
	public Pair(Object o1, Object o2) {
		obj1 = o1;
		obj2 = o2;
	}
	boolean equals(Pair b) {
		return (b.obj1.equals(this.obj1) && b.obj2.equals(this.obj2));
	}
	
	public String toString() {
		return obj1+" "+obj2;
	}
}

