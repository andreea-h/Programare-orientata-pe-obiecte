
public class Test {

	public static void main(String[] args) {
		SortedVector v1 = new SortedVector(new MyComp1());
		SortedVector v2 = new SortedVector(new MyComp2());
		v1.add(new Pair("b",1));
		v1.add(new Pair("a",2));
		v1.add(new Pair("c",3));
		v2.add(new Pair("d", 4));
		v2.add(new Pair("e", 5));
		v2.add(new Pair("f", 6));
		
		System.out.println(v1);
		System.out.println(v2);
	}

}
