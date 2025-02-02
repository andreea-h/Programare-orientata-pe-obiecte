import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

class MyComparator implements Comparator{
	public int compare(Object obj1, Object obj2) {
		return ((String)obj2).compareTo((String)obj1);
	}
}
public class SListSet extends LinkedList implements SortedSet {
	Comparator comp;
	SListSet obj;
	
	
	public SListSet() {
		comp=null;
	}
	
	public SListSet(Comparator comp) {
		this.comp = comp;
	}
	
	public Comparator comparator() {
		return comp;
	}
	
	
	public Object first() {
		return super.getFirst();
	}
	public Object last() {
		return super.getLast();
	}
	
	public SortedSet subSet(Object from,Object to) {
		SortedSet rez=null;
		int f=0, l=0,i;
		for(i=0;i<this.size();i++) {
			if(this.get(i)==from)
				f=i;
			if(this.get(i)==to)
				l=i;
		}
		for(i=f;i<l;i++) {
			rez.add(this.get(i));
		}
		return rez;
	}
	
	public SortedSet headSet(Object to) {
		return this.headSet(to);
	}
	public SortedSet tailSet(Object from) {
		return this.tailSet(from);
	}	
	
	public SListSet printWords(String file) throws IOException {
		RandomAccessFile f = new RandomAccessFile(file,"r");
		String s;
		int i;
		while((s=f.readLine())!=null) {
			StringTokenizer cuvinte=new StringTokenizer(s, " <>=\"*.,/+-?!:;()[]{}0123456789\t");
			while(cuvinte.hasMoreTokens())
			{
			String element = new String(cuvinte.nextToken());
			if(this.contains(element)==false)
				this.add(element);
				Collections.sort(this,new MyComparator());
			}
		}
		return this;
	}
	
	
}
