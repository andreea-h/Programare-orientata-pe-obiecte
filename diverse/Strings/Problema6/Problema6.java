import java.util.*;
public class Problema6 {

	public static void main(String[] args) {
		Vector vect = new Vector();
		vect.add(7.5);
		vect.add("String");
		vect.add(10);
		vect.add(-10.16);
		vect.add(true);
		vect.add('a');
		int i;
		Vector freq = new Vector();
		for( i=0; i<5 ;i++)
			freq.add(0);
		for(i=0;i<vect.size()-1;i++) {
			Class a = vect.get(i).getClass();
			System.out.println(a.getName());
			String s = a.getName();
			if(s.equals("java.lang.Double")) {
				int t=(int)freq.get(0) + 1;
				freq.set(0,t);
			}
		}
		  System.out.println(freq.get(0));
		//if (vect.get(0).getClass().equals("class java.lang.Double"))
		//	System.out.println("da");
		//for (i=0; i<vect.size(); i++)
		//	System.out.println(vect.get(i).getClass());
		
	}

}
