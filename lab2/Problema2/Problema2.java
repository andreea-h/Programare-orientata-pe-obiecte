import java.util.StringTokenizer;

public class Problema2 {
	
	//folosind metoda split
	int aparitii1(String s1, String s2) {
		String s3[] = s1.split(" ");
		int i;
		int k=0;
		for(i=0;i<s3.length;i++) {
			if(s3[i].equals(s2)) {
				k++;
			}
		}
		return k;
	}
	
	//folosind metoda StringTokenizer
	int aparitii2(String s1, String s2) {
		int k=0;
		StringTokenizer s = new StringTokenizer(s1,": , . - ?");
		while(s.hasMoreTokens()) {
			if(s.nextToken().equals(s2))
				k++;
		}
		return k;
	}
	
	public static void main(String[] args) {
		String s1=new String(args[0]);
		String s2=new String(args[1]);
		Problema2 obiect = new Problema2();
		System.out.println(obiect.aparitii1(s1,s2));
		System.out.println(obiect.aparitii2(s1,s2));
	}

}
