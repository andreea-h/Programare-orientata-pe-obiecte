import java.util.*;
public class Test02 {

	public static void main(String[] args) {
		/*ArrayMap<Vector, Vector> map = new ArrayMap<>();
        Vector key = new Vector();
        Vector values = new Vector();
        key.add(5);
        key.add(6);
        key.add(7);
        values.add("ana");
        values.add("are");
        values.add("mere");
        System.out.println("Populam colectia...");
        map.put(key, values);

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + map);*/
		ArrayMap<Integer, String> map = new ArrayMap<>();
		 Vector key = new Vector();
	     Vector values = new Vector();
	     key.add(5);
	     key.add(6);
	     key.add(7);
	     values.add("ana");
	     values.add("are");
	     values.add("mere");
	     int i;
	     for(i=0;i<key.size();i++) {
	    	 Integer o1 = (Integer)key.get(i);
	    	 String o2 = (String)values.get(i);
	    	 map.put(o1,o2);
	     }
	     
	     System.out.println(map);
	     System.out.println("Afisare folosind 'entrySet'");
	     Iterator iterator=map.entrySet().iterator();
	     while(iterator.hasNext()) {
	    	 System.out.println(iterator.next());
	     }


	}

}
