package prb1;
class Patrat {
	public static void main(String args[]) {
		String s= new String ("test");
		StringBuffer sb= new StringBuffer ("test");
		s.concat("unu");
		sb.append("unu");
		System.out.println(s); //test
		System.out.println(sb); // testunu
		System.out.println(s.concat("unu"));
	}
}


