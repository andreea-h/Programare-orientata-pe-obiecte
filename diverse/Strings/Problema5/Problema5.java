import java.util.*;
public class Problema5 {

	public static StringBuffer cenzurare(String text, String cuvinte[]) {
	//	StringTokenizer sir = new StringTokenizer(text," ");
		int i, pos;
		int ok=0;
		StringBuffer sir = new StringBuffer(text);
		for (i=0; i<cuvinte.length; i++) {
			pos = sir.indexOf(cuvinte[i],0);
			if(pos != -1) {
				ok=1;
		    int j;
		    StringBuffer code = new StringBuffer();
		    for(j=0; j<cuvinte[i].length()-2 ;j++)
		    	code.append("*");
		    String code1 = new String(code);
			sir.replace(pos+1, pos+cuvinte[i].length()-1,code1 );	
			}
		}
		if(ok==0) {
			System.out.println("Nimic suspect");
		}
		else
			System.out.println("Text suspect");
		return sir;	
	}
	public static void main(String[] args) {
		String text = "Ana";
		String cuvinte[] = new String[2];
		cuvinte[0] = "terorist";
		cuvinte[1] = "bomba";
		Problema5 obiect = new Problema5();
		System.out.println(obiect.cenzurare(text, cuvinte));
	}

}
