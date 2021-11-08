import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		GenericListMethods list = new GenericListMethods();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(30);
		list1.add(90);
		list1.add(30);
		list1.add(80);
		System.out.println("Inainte de a aplica 'removeDuplicates':");
		System.out.println(list1);
		System.out.println("Dupa aplicarea metodei 'removeDuplicates'");
		list1=list.removeDuplicates(list1);
		System.out.println(list1);
		System.out.println("Valoarea maxima din lista:");
		System.out.println(list.max(list1));
		Collections.sort(list1);
		System.out.println("Lista ordonata este:");
		System.out.println(list1);
		System.out.println("Valoarea cautata este 30");
		System.out.println("Aceasta se gaseste la indexul:");
		Integer obj = new Integer(30);
		System.out.println(list.binarySearch(list1,obj,0,list1.size()));
		
		System.out.println("Valoarea cautata este 90");
		System.out.println("Aceasta se gaseste la indexul:");
		Integer obj1 = new Integer(90);
		System.out.println(list.binarySearch(list1,obj1,0,list1.size()));
	}

}
