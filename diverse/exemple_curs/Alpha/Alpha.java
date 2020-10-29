import java.util.*;
	
class Alpha {
	static String s = " ";
	protected Alpha() {
		s+="alpha";
	}
}

class SubAlpha extends Alpha {
	private SubAlpha() {
		s+="sub";
	}
}

class SubSubAlpha extends Alpha {
	static String var = "ana";
	static String s;
	private SubSubAlpha() {
		s+="subsub";
		var = "maria";
	}
	
	public static void main(String args[]) {
		new SubSubAlpha();
		System.out.println(s);
		System.out.println(var);
		List myList = new ArrayList();
		myList.add(0);
		int x = (Integer)myList.get(0); //unboxing automat
		List<Integer> list2 = new ArrayList();
		list2.add(new Integer(8));
		int y = list2.get(0);
		System.out.println(y);
	}
}
