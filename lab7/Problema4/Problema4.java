import java.io.RandomAccessFile;
import java.util.*;
import java.io.*;

 public class Problema4 {
	TreeMap<String,LinkedList>dictionar;
	
	public Problema4() {
		dictionar = new TreeMap<String,LinkedList>();
	}
	//file - numele fisierului de intrare
	public TreeMap construire_dictionar(String file) throws IOException {
		RandomAccessFile f = new RandomAccessFile(file,"r");
		String s;
		int count=0;
		
		while((s=f.readLine())!=null) {
			count=count+1;
			StringTokenizer cuvinte=new StringTokenizer(s, " <>=\"*.,/+-?!:;()[]{}0123456789\t");
				while(cuvinte.hasMoreTokens()){
					String element = new String(cuvinte.nextToken());
					if(dictionar.containsKey(element)==false) {
						LinkedList lst=new LinkedList();
					    lst.add(count);
					    dictionar.put(element,lst);
					}
					else {
						LinkedList lst=dictionar.get(element);
						if(lst.contains(count)==false)
							lst.add(count);
					}
				}
		}
		return dictionar;
	}
	
	public void afisare(TreeMap dictionar) {
			Set set = dictionar.entrySet();
			//itr - iterator pe multimea intrarilor din dictionar
	        Iterator itr=set.iterator();
	        while(itr.hasNext()) {
	        	Map.Entry intrare =(Map.Entry)itr.next();
	        	System.out.println(intrare.getKey());
	        	System.out.println(intrare.getValue());
	        	System.out.println("Cuvantul apare pe "+ ((LinkedList)(intrare.getValue())).size()+" linii");
	        }
	}
	
		
}
