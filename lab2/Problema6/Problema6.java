import java.util.*;
public class Problema6 {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.add(7.5);
		v.add(10);
		v.add(12);
		v.add("String");
		v.add("Cuvinte");
		v.add(-12);
		v.add('e');
		v.add(true);
		v.add(false);
		System.out.println("Vectorul este: " + v);
		int i;
		Vector contor = new Vector(); //vector pentru contorizare aparitii
		for(int y=0;y<6;y++)
			contor.add(0);
		String s1 = new String("java.lang.Integer");
		String s2 = new String("java.lang.Double");
		String s3 = new String("java.lang.Float");
		String s4 = new String("java.lang.String");
		String s5 = new String("java.lang.Character");
		String s6 = new String("java.lang.Boolean");
		for(i=0;i<v.size()-1;i++) {
			Class a = v.get(i).getClass();
		//	System.out.println(a.getName());
			String s = new String(a.getName());
			if(s.equals(s1)) {
				int val = (int)contor.get(0) +1;
				contor.set(0,val);
			}
			if(s.equals(s2)) {
				int val = (int)contor.get(1) +1;
				contor.set(1,val);
			}
			if(s.equals(s3)) {
				int val = (int)contor.get(2) +1;
				contor.set(2,val);
			}
			if(s.equals(s4)) {
				int val = (int)contor.get(3) +1;
				contor.set(3,val);
			}
			if(s.equals(s5)) {
				int val = (int)contor.get(4) +1;
				contor.set(4,val);
			}
			if(s.equals(s6)) {
				int val = (int)contor.get(5) +1;
				contor.set(5,val);
			}
		}
		System.out.println(contor);
	
	}

}
