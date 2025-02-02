import java.io.*;
import java.util.*;
public class Filtru implements FilenameFilter {
	Vector extensions; //extensiile acceptate
	Vector words;  //cuvintele acceptate
	
	public Filtru(String FilePath1, String FilePath2) {
		extensions = new Vector();
		words = new Vector();
		try {
			//citeste din cele 2 fisiere extensiile acceptate si cuvinetele acceptate
			RandomAccessFile extensii= new RandomAccessFile(FilePath1, "r");
			String linie = new String();
			while((linie = extensii.readLine())!=null) {
				extensions.add(linie);
			}
			RandomAccessFile cuvinte = new RandomAccessFile(FilePath2,"r");
			String linie1 = new String();
			while((linie1 = cuvinte.readLine())!=null) {
				words.add(linie1);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean accept(File dir, String name) {
		boolean ok = false;
		int i;
		for(i=0;i<extensions.size();i++) { //daca fisierul nu are una don extensiile acceptate
			if(name.endsWith(""+extensions.get(i)))
				ok = true;
		}
		if(ok==false) {
			return  false;
		}
		//verificam daca fisierul are nume acceptat
		else {
			ok =  false;
			for(i=0;i<words.size();i++) {
				if(name.contains(words.get(i)+"")) {
					ok = true;
				}
		}
		return ok;
	}
}
	public static void main(String[] args) {
		Filtru f = new Filtru("../Arhiva6/extension.in","../Arhiva6/words.in");
		System.out.println(f.extensions);
		System.out.println(f.words);
		File director = new File("../Arhiva6/director");
		File[] continut = director.listFiles();
		int i,j;
		for(i=0;i<continut.length;i++) {
			File director1 = new File(continut[i]+"");
			File[] continut1 = director1.listFiles();
			for(j = 0; j < continut1.length; j++) {
				System.out.println(continut1[j]+"");
				System.out.println(f.accept(null,""+continut1[j]));
				}

		}


	}
}
