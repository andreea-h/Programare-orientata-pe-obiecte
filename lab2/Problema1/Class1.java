
public class Class1 {

	public static void main(String[] args) {
		String s1 = "si";
		String s2 = "sir1 si cu sir2 fac un sir3sisisi1";
		int k = 0, i, j;
		for (i=0; i < s2.length(); i++) {
			for(j=i+1 ; j < s2.length(); j++) {
				String s3 = s2.substring(i,j);
				if(s3.equals(s1))
					k++;
		}
		}
	System.out.println(k);
    int k2 = 0, pos;
    for (i=0; i < s2.length(); i++) {
    	pos = s2.indexOf(s1, i);
    	if(pos!=-1) {
    		k2++;
    		i =  pos + s1.length() -1;
    	}
    }
    System.out.println(k2);
	}
}

