
import java.util.*;
import java.io.*;
class MyTreeSet{
	TreeSet<String> obj1;
	TreeSet<String> obj2;
	
	public MyTreeSet() {
		obj2=new TreeSet<String>(new MyComparator());
		obj1=new TreeSet<String>();
	}
	
	public TreeSet printWords(String file) throws IOException {
		RandomAccessFile f = new RandomAccessFile(file,"r");
		String s;
		int i;
		while((s=f.readLine())!=null) {
			StringTokenizer cuvinte=new StringTokenizer(s, " <>=\"*.,/+-?!:;()[]{}0123456789\t");
			while(cuvinte.hasMoreTokens())
			{
			String element = new String(cuvinte.nextToken());
			if(obj1.contains(element)==false)
				obj1.add(element);
			}
		}
		return obj1;
	}
	
	public TreeSet printWordsComparator(TreeSet s) {
		TreeSet obj3=new TreeSet<String>(new MyComparator());
	    Iterator count=s.iterator();
	    while(count.hasNext())
	    	obj3.add(count.next());
		return obj3;
	}
	
}

class MyComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
}
