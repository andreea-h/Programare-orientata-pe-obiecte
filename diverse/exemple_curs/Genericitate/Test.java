import java.util.*;


public class Test {

	public static void main(String[] args) {
		/*List<?> someList = new ArrayList<String>();
		System.out.println(someList.getClass().getName());
		((ArrayList<Integer>)someList).add(1);
		Object el = someList.get(0);
		System.out.println(someList.get(0).getClass());
		System.out.print(someList);*/
		
		List<?> someList = new ArrayList<String>();
		((ArrayList<String>)someList).add("Some String");
		((ArrayList<Integer>)someList).add(1);
		Object item = someList.get(0);
		System.out.println(item);
		item = someList.get(1);
		System.out.println(item);

	}

}
