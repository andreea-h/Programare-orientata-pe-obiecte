import java.util.*;
public class NrAparitii {
	
	public static int Aparitii1(String s1, String s2) {
		String[] s3 = s2.split(" ");
		//System.out.println(s3[0]);
		//compara fiecare element din s3 cu s1
		int k=0, i;
		for(i=0; i < s3.length; i++) {
			if(s3[i].equals(s1))
				k++;
		}
		return k;
	}
	
	public static int Aparitii2(String s1, String s2) {
		StringTokenizer s3 = new StringTokenizer(s2," : , . - ? ");
		int k=0;
		while(s3.hasMoreTokens()) {
			if(s3.nextToken().contentEquals(s1))
				k++;
		}
		return k;
	}
	
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
	//	String[] s3 = s2.split(" ");
		//Aparitii obiect = new Aparitii();
		System.out.println(Aparitii1(s1,s2));
		System.out.println(Aparitii2(s1,s2));
	}

}
