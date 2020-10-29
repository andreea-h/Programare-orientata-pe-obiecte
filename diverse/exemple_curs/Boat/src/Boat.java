import java.util.*;

interface Vessel {
}

interface Toy {
	
}


class Dog implements Comparable{
	int size;
	Dog(int s) {
		size = s;
	}
	public int compareTo(Object a) {
		return (this.size-((Dog)a).size);
	}
	public String toString() {
		return "Dog"+size;
	}
}

class Boat implements Vessel{

}

class Speedboat extends Boat implements Toy {	
}

class Tree {
	public static void main(String[] args) {
		String s = "0";
		Boat b = new Boat();
		Boat b2 = new Speedboat();
		Speedboat s2 = new Speedboat();
		if((b instanceof Vessel) && (b2 instanceof Toy)) 
			s += "1";
		if((s2 instanceof Vessel) && (s2 instanceof Toy)) 
			s += "2";
		System.out.println(s);
		
		int[]a = {1,3,5,7,9};
		for(int x : a) {
			for(int j = 0; j < 3; j++) {
				if(x > 4 && x < 8) continue;
				System.out.print(" " + x);
			if(j == 1) 
				break;
			continue;
			}
			continue;
			}
		
		String s1="abc";
		String s3="def";
		//s1+="d";
		System.out.println(s1==s3);//compara referintele
		System.out.println(s1.equals(s3)); //compara continutul 
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = sb1;
		sb1.append("a");
		System.out.println(sb1==sb2); //compara referintele
		System.out.println(sb2);
		
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		
		for(int i=0;i<=10;i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(i*i);
			table.add(row);
		}
		
		for(List<Integer> row: table) {
			System.out.println(row);
		}
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		/*((TreeSet<Integer>)set).*/set.add(10);
	    set.add(20);
	  // ((TreeSet<String>)set).add("astcy");
		System.out.println(set);
		
		TreeSet<Dog> d = new TreeSet<Dog>();
		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
		System.out.println(d);
	
		class Horse {
			public String name;
			public Horse(String s) {
				name=s;
			}
			String getName() {
				return name;
			}
		}
		
		Object obj = new Horse("ceva");
		System.out.println(obj.getClass().getName());
		//System.out.println(obj.name);
	}
	
	
}
