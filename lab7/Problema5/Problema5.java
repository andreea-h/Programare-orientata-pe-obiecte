import java.util.*;
import java.io.*;

class MyComparator implements Comparator {
	Map map;
	public MyComparator(Map map) {
		this.map=map;
	}
	public int compare(Object keya, Object keyb) {
		Comparable valA = (Comparable)map.get(keya);
		Comparable valB = (Comparable)map.get(keyb);
		return valA.compareTo(valB);
	}
}

public class Problema5 {
	HashMap<String, Integer> a1;
	TreeMap<String, Integer> a2;
	
	public Problema5() {
		a1=new HashMap();
		a2=new TreeMap();
	}
	
	public Map creeazaMap(String director) {
		File f = new File(director);
		String[] file = f.list();
		int i;
		for(i=0;i<file.length;i++)
			a1.put(file[i],(file[i].length()));
			Map sortedMap = new TreeMap(new MyComparator(a1));
			sortedMap.putAll(a1);
		return sortedMap;
	}
	
	public 	TreeMap creeazaMapVar2(String director) {
		File f = new File(director);
		String[] file = f.list();
		int i;
		for(i=0;i<file.length;i++)
			a2.put(file[i],(file[i].length()));
		return a2;
	}
	
	
	public void afisare() {
		System.out.println(a1);
	}

}
