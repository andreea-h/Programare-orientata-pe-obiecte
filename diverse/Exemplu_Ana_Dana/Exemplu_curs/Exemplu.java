import java.util.*;
public class Exemplu {

	public static void main(String[] args) {
	/*	List<?> someList = new ArrayList<String>();
		((ArrayList<Integer>)someList).add(1);
		System.out.print(someList);
		*/
		//sau new ArrayList<String>()
		List<?> someList = new ArrayList<>();
		((ArrayList<String>)someList).add("Some String");
		((ArrayList<Integer>)someList).add(1);
		Object item = someList.get(0);
		System.out.println(item);
		item = someList.get(1);
		System.out.println(item);
	}

}
