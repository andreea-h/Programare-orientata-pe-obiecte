import java.util.*;

public class Problema5 {
	
	String cenzurare(String text, String cuvinte[]) {
		int i, pos;
		int ok=0;
		StringBuffer sir = new StringBuffer(text);
		for (i=0; i<cuvinte.length; i++) {
			pos = sir.indexOf(cuvinte[i],0);
			if(pos != -1) { //s-a gasit cuvantul in text
				ok=1;
		    int j;
		    StringBuffer code = new StringBuffer();
		    for(j=0; j<cuvinte[i].length()-2 ;j++)
		    	code.append("*");
		    String code1 = new String(code);
			sir.replace(pos+1, pos+cuvinte[i].length()-1,code1);	
			}
		}
		if(ok==0) {
			System.out.println("Nimic suspect");
		}
		else
			System.out.println("Text suspect");
		String rezultat = new String(sir);
		return rezultat;	
	}

	public static void main(String[] args) {
		String text = "Un terorist avea o bomba";
		String cuvinte[] = new String[2];
		cuvinte[0] = "terorist";
		cuvinte[1] = "bomba";
		Problema5 obiect = new Problema5();
		String rezultat;
		rezultat = obiect.cenzurare(text, cuvinte);
		System.out.println(rezultat);

	}

}
