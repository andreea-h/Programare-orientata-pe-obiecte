import java.util.*;

class Top {
	public Top() {
		
	}
public Top(String s) { System.out.print("B"); }
}
 class Bottom2 extends Top {
public Bottom2(String s) { System.out.print("D");}
public static void main(String [] args) {
new Bottom2("C");
	System.out.println(" ");
	List<String> list = new ArrayList<String>();
	list.add(0,"ceva");
	String total = list.get(0);
	System.out.println(total);
	int x = 0;
	try {  x = Integer.parseInt("9"); }
	catch(NumberFormatException e) {
		//e.printStackTrace();
		System.out.println("NUmber FOrmat Ecmfnbr");
	}
	finally {
		System.out.println(x);
		if(Integer.parseInt("011") == Integer.parseInt("0011")) {
			System.out.println("ceva2");
		}
	}
	
	String s = " ";
	if(Integer.parseInt("011") == Integer.parseInt("9")) {
		s+=1;
	}
	System.out.println(Integer.valueOf("17").getClass().getName());
	System.out.println(021);
	if(0x21 == Integer.valueOf("17")) 
		s += 2;
	if(1024 == new Integer(1024)) 
		s += 3;
	System.out.println(s);
	
	try {
		throw new Error();
	}
	catch(Error e) {
		try {
			throw new RuntimeException();
		}
		catch(Throwable t) {
		}
		System.out.println("IOIOO");
	}
	
	
	
	
} }