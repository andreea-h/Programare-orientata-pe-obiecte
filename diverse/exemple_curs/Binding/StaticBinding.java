import java.util.*;
public class StaticBinding {

	public static void main(String[] args) {
		StaticBinding test = new StaticBinding();
		Collection c = new HashSet();
		test.sort(c); //static binding (la compilare)
	}
	
	public Collection sort(Collection c) {
		System.out.println("In metoda sort(Collection)");
		return c;
	}
	
	public Collection sort(HashSet hs) {
		System.out.println("In metoda sort(HashSet");
		return hs;
	}

}
