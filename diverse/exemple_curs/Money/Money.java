import java.util.*;

class Student {
	String name;
	
	public Student() {
		this("ceva");
	}
	
	public Student(String a) {
		name=a;
	}
	public void getInfo1() {
		return;
	}
	public String getInfo2() {
		return name;
	}
	
	static int count(int x, int y) {
		return x+y;
	}
}

class Test extends Student{
	public static void main(String []args) {
		Student s = new Student("fvni");
		System.out.println(s.getInfo2());
		s=null;
	//	s.getInfo1();
		
		Object []list = {new Integer(12),new String("foo"), new Boolean(true)};
	//	Arrays.sort(list);
		
		Set set = new HashSet();
		set.add("1");
		set.add(1);
		set.add(null);
		set.add("null");
		System.out.println(set);
		
		List<? extends Number> list1 = null;
		List<Integer> list2 = null;
		list1 = list2; //orice Integer este un subtip al lui number
		
	//	Collection <? super Integer> coll = new Collection<>();
	
		List<Number> list11 = new ArrayList<>();
		List<? super Integer> list22 = new ArrayList<>();
		//list11 = list22; //nu orice supertip al lui Integer este Number
		list11.add(10);
		Double d = new Double(10);
		System.out.println(d);
		Number n = d;
		((List<Number>)list22).add(n);
		System.out.println(list22);
	
	
		List<? extends Number> col2 = new LinkedList<Number>();
	    ((List<Integer>)col2).add(new Integer(2));
	    System.out.println(col2);
	
	
	    List<? super Double> col3 = new ArrayList<Number>();
	    ((List<Double>)col2).add(new Double(2));
	    col3.add(new Double(10));
	
	//    List<? extends Double> col3 = new ArrayList<Number>();
	    ((List<Double>)col2).add(new Double(2));
	    col3.add(new Double(10));
	    
	  //  Collection<Integer> col5 = new List<Integer>();
	    List ceva = new ArrayList();
	    
	    Short my = 7;
	    System.out.println(count(my, 6));
	}
	
}